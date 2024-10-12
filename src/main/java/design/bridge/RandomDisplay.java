package design.bridge;

import java.util.Random;

/** 功能层次
 * @author hason
 * @since 2023/6/8 14:35
 */
public class RandomDisplay extends Display {

    public RandomDisplay(DisplayImpl display) {
        super(display);
    }

    public void randomDisplay(int times) {
        Random ran = new Random();
        int n = ran.nextInt(times);
        open();
        for (int i = 0; i < n; i++) {
            print();
        }
        close();
    }

}
