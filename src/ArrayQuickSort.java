import java.util.Comparator;
import java.util.Random;

public class ArrayQuickSort<T> implements ArraySorter<T> {
    private Comparator<T> _comparator;
    private Random random;

    public ArrayQuickSort(Comparator<T> comparator) {
        _comparator = comparator;
        random = new Random();
    }

    public T[] sort(T[] list) {
        quicksort(list, 0, list.length);
        return list;
    }

    private void quicksort(T[] list, int startIndex, int endIndex) {
        if (endIndex - startIndex > 1) {
            int partition = partition(list, startIndex, endIndex);
            quicksort(list, startIndex, partition);
            quicksort(list, partition + 1, endIndex);
        }
    }

    private int partition(T[] list, int nFrom, int nTo) {
//jako element dzielący bierzemy losowy
        int rnd = nFrom + random.nextInt(nTo - nFrom);
        swap(list, nFrom, rnd);
        T value = list[nFrom];
        int idxBigger = nFrom + 1, idxLower = nTo - 1;
        do {
            while (idxBigger <= idxLower && _comparator.compare(list[idxBigger], value) <= 0)
                idxBigger++;
            while (_comparator.compare(list[idxLower], value) > 0)
                idxLower--;
            if (idxBigger < idxLower)
                swap(list, idxBigger, idxLower);
        } while (idxBigger < idxLower);
        swap(list, idxLower, nFrom);
        return idxLower;
    }

    private void swap(T[] list, int left, int right) {
        if (left != right) {
            T temp = list[left];
            list[left] = list[right];
            list[right] = temp;
        }
    }
}
/*
{
// wynikiem jest posortowana oryginalna lista
public IList<T> sort(IList<T> list){
        quicksort(list,0,list.size()-1);
        return list;
        }
private void quicksort(IList<T> list,int startIndex,int endIndex){
        if(endIndex>startIndex){
        int partition=partition(list,startIndex,endIndex);
        quicksort(list,startIndex,partition);
        quicksort(list,partition+1,endIndex);}
        }
// podział według Lomuto
private int partition(IList<T> list,int left,int right){
//jako element dzielący bierzemy ostatni
        T value=list.get(right);
        int i=left-1;
        while(left<=right){
        if(_comparator.compare(list.get(left),value)<=0)
        swap(list,++i,left);
        ++left;}
        return i<right ?i:i-1;
        }
private void swap(IList<T> list,int left,int right){
        if(left!=right){
        T temp=list.get(left);
        list.set(left,list.get(right));
        list.set(right,temp);}
        }
        }


 */