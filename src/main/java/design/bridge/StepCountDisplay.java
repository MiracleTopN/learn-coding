package design.bridge;

/** 功能层次
 * @author hason
 * @since 2023/6/8 23:01
 */
public class StepCountDisplay extends CountDisplay {

    private int step;

    public StepCountDisplay(DisplayImpl display, int step) {
        super(display);
        this.step = step;
    }

    public void stepMultiDisplay(int level) {
        int count = 0;
        for (int i = 0; i < level; i++) {
            multiDisplay(count);
            count += step;
        }
    }
}
