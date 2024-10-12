package design.stragegy.sort;

/**
 * @author hason
 * @since 2023/6/11 15:40
 */
public class SortAndPrint {

    private Comparable[] data;

    private Sorter sorter;

    public SortAndPrint(Comparable[] data, Sorter sorter) {
        this.data = data;
        this.sorter = sorter;
    }

    public void execute() {
        print();
        sorter.sort(data);
        print();
    }

    private void print() {
        System.out.println(sorter.getClass().getName() + ":");
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + ",");
        }
        System.out.println("");
    }

}
