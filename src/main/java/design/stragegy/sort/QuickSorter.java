package design.stragegy.sort;

import java.util.Random;

/**
 * @author hason
 * @since 2023/6/12 00:44
 */
public class QuickSorter implements Sorter {
    @Override
    public void sort(Comparable[] data) {
        int start = 0, end = data.length - 1;
        quickSort(data, start, end);
    }

    // 从小到大
    private void quickSort(Comparable[] data, int start, int end) {
        if (start >= end) {
            return;
        }
        int partition = partition(data, start, end);
        quickSort(data, start, partition - 1);
        quickSort(data, partition + 1, end);
    }

    private int partition(Comparable[] data, int start, int end) {
        int pivotIndex = getPivot(start, end);
        Comparable pivot = data[pivotIndex];
        // 如果选取中间的位置 要将pivot与start或end交换 保证pivot元素位置的固定 ，因为最终还是要以pivot元素进行分割
        swap(data, pivotIndex, start);
        int left = start, right = end;
        while (left != right) {
            while (data[left].compareTo(pivot) <= 0 && left < right) {
                left++;
            }
            while (data[right].compareTo(pivot) > 0 && left < right) {
                right--;
            }
            if (left < right) {
                swap(data, left, right);
            }
        }
        // ** 修正pivot元素的位置 **quickSort
        // 因为上述步骤的结果虽然是按照pivot的值进行分割，但是没有按照pivot的位置分割
        // 所以这里要将pivot元素放回到pivot位置 使得pivot位置左边的元素都小于mid 右边的元素都大于mid
        if (data[left].compareTo(pivot) <= 0) {
            swap(data, start, left);
            return left;
        } else {
            swap(data, start, left - 1);
            return left - 1;
        }
    }

    private int getPivot(int start, int end) {
        Random ran = new Random(10);
        return start + ran.nextInt(end - start);
    }

    private void swap(Comparable[] data, int a, int b) {
        Comparable temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }
}
