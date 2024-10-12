package design.decorator;

/**
 * @author hason
 * @since 2023/6/16 18:39
 */
public abstract class Display {

    public abstract int getColumns();

    public abstract int getRows();

    public abstract String getRowText(int row);

    public final void show() {
        for (int i = 0; i < getRows(); i++) {
            System.out.println(getRowText(i));
        }
    }

}
