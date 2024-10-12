package design.stragegy.sort;

/**
 * @author hason
 * @since 2023/6/11 15:27
 */
public class SelectionSorter implements Sorter {
    @Override
    public void sort(Comparable[] data) {
        for (int i = 0; i < data.length; i++) {
            int min = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[i].compareTo(data[j]) > 0) {
                    min = j;
                }
            }
            swap(data, i, min);
        }
    }

    public void swap(Comparable[] data, int a, int b) {
        Comparable temp = data[b];
        data[b] = data[a];
        data[a] = temp;
    }
}
