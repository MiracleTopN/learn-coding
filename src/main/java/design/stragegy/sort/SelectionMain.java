package design.stragegy.sort;

/**
 * @author hason
 * @since 2023/6/11 15:43
 */
public class SelectionMain {

    public static void main(String[] args) {
        String[] data = {
            "Dumpty", "Bowman", "Carroll", "Elfland", "Alice"
        };
//        SortAndPrint selectSort = new SortAndPrint(data, new SelectionSorter());
        SortAndPrint quickSort = new SortAndPrint(data, new QuickSorter());
//        SortAndPrint quickSortSimplified = new SortAndPrint(data, new QuickSorterSimplified());
//        selectSort.execute();
        quickSort.execute();
//        quickSortSimplified.execute();
    }
}
