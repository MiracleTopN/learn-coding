package design.bridge;

/**
 * @author hason
 * @since 2023/6/8 14:08
 */
public class Display {

    private DisplayImpl display;

    public Display(DisplayImpl display) {
        this.display = display;
    }

    public void open() {
        display.rawOpen();
    }

    public void print() {
        display.rawPrint();
    }

    public void close() {
        display.rawClose();
    }

    public final void display() {
        open();
        print();
        close();
    }

}
