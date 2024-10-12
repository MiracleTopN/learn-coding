package design.stragegy.fingerguess;

import java.util.Random;

/**
 * @author hason
 * @since 2023/6/10 19:48
 */
public class WinningStrategy implements Strategy {

    private Random random;

    private boolean won = false;

    private Hand prevHand;

    public WinningStrategy(int seed) {
        random = new Random(seed);
    }

    @Override
    public Hand nextHand() {
        if (!won) {
            prevHand = Hand.getHand(random.nextInt(3));
        }
        return prevHand;
    }

    @Override
    public void study(boolean win) {
        won = win;
    }
}
