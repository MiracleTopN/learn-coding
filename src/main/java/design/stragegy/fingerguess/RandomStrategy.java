package design.stragegy.fingerguess;

import java.util.Random;

/**
 * @author hason
 * @since 2023/6/11 14:48
 */
public class RandomStrategy implements Strategy {

    private Random random;

    public RandomStrategy(int seed) {
        random = new Random(seed);
    }

    @Override
    public Hand nextHand() {
        return Hand.getHand(random.nextInt(3));
    }

    @Override
    public void study(boolean win) {

    }
}
