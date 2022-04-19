import java.util.*;

public class ArrayMergeSort<T> implements ArraySorter<T> {
    Comparator<T> _comparator;

    public ArrayMergeSort(Comparator<T> comparator) {
        _comparator = comparator;
    }

    // wynikiem jest nowa lista
    public T[] sort(T[] list0) {
        ArrayList<T> list = new ArrayList<T>(Arrays.asList(list0));
        return (T[]) mergesort(list, 0, list.size() - 1).toArray();
    }

    @SuppressWarnings("unchecked")
    private AbstractList<T> mergesort(AbstractList<T> list, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            AbstractList<T> result = (AbstractList<T>) (new ArrayList<Object>());
            result.add(list.get(startIndex));
            return result;
        }
        int splitIndex = startIndex + (endIndex - startIndex) / 2;
        return merge(mergesort(list, startIndex, splitIndex),
                mergesort(list, splitIndex + 1, endIndex));
    }

    //@SuppressWarnings("unchecked")
    private AbstractList<T> merge(AbstractList<T> left, AbstractList<T> right) {
// mimo wszystko musimy się zdecydować na konkretną implementację listy
        AbstractList<T> result = new ArrayList<T>();
        Iterator<T> l = left.iterator();
        Iterator<T> r = right.iterator();
        T elemL = null, elemR = null;
// musimy opóźnić wychodzenie z pętli do czasu dodania do wyniku
// ostatniego elementu jednego z ciągów
        boolean contL = l.hasNext();
        boolean contR = r.hasNext();
        if (contL) elemL = l.next();
        if (contR) elemR = r.next();
        while (contL && contR) {
            if (_comparator.compare(elemL, elemR) <= 0) {
                result.add(elemL);
                if (contL = l.hasNext()) elemL = l.next();
                else result.add(elemR);
            } //już odczytany element drugiej listy do wyniku
            else {
                result.add(elemR);
                if (contR = r.hasNext()) elemR = r.next();
                else result.add(elemL);
            } //już odczytany element pierwszej listy do wyniku
        }
        while (l.hasNext()) result.add(l.next());
        while (r.hasNext()) result.add(r.next());
        return result;
    }
}
