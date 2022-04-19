import java.util.Arrays;
import java.util.Comparator;

public class ArrayInsertSort<T> implements ArraySorter<T> {
    private final Comparator<T> _comparator;

    public ArrayInsertSort(Comparator<T> comparator) {
        _comparator = comparator;
    }

    public T[] sort(T[] list) {
        for (int i = 1; i < list.length; ++i) {
            T value = list[i], temp;
            int j;
            for (j = i; j > 0 && _comparator.compare(value, temp = list[j - 1]) < 0; --j)
                list[j] = temp;
            list[j] = value;
            //System.out.println(Arrays.toString(list));
        }
        return list;
    }
}
