import java.util.Arrays;
import java.util.Comparator;

public class ArrayMaxHeapSort<T> implements ArraySorter<T> {
    private final Comparator<T> _comparator;

    public ArrayMaxHeapSort(Comparator<T> comparator) {
        _comparator = comparator;
    }

    @Override
    public T[] sort(T[] list) {
        heapsort(list, list.length);
        return list;
    }

    private void heapsort(T[] heap, int n) {
        heapAdjustment(heap, n);
        for (int i = n - 1; i > 0; i--) {
            swap(heap, i, 0);
            sink(heap, 0, i);
            //System.out.println(Arrays.toString(heap));
        }
    }

    /**
     * założenie: left != right
     */
    private void swap(T[] list, int left, int right) {
        T temp = list[(left)];
        list[left] = list[right];
        list[right] = temp;
    }

    public void sink(T[] heap, int idx, int n) {
        int idxOfBigger = 2 * idx + 1;
        if (idxOfBigger < n) {
            if (idxOfBigger + 1 < n &&
                    _comparator.compare(heap[idxOfBigger], heap[idxOfBigger + 1]) < 0)
                idxOfBigger++;
            if (_comparator.compare(heap[idx], heap[idxOfBigger]) < 0) {
                swap(heap, idx, idxOfBigger);
                sink(heap, idxOfBigger, n);
            }
        }
    }

    void heapAdjustment(T[] heap, int n) {
        for (int i = (n - 1) / 2; i >= 0; i--)
            sink(heap, i, n);
    }
}
