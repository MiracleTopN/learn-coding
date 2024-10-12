package design.bridge;

/**
 * 功能层次
 * @author hason
 * @since 2023/6/8 14:22
 */
public class CountDisplay extends Display {
    public CountDisplay(DisplayImpl display) {
        super(display);
    }

    public void multiDisplay(int times) {
        open();
        for (int i = 0; i < times; i++) {
            print();
        }
        close();
    }
}
