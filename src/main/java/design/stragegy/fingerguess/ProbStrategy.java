package design.stragegy.fingerguess;

import java.util.Random;

/**
 * @author hason
 * @since 2023/6/10 19:55
 */
public class ProbStrategy implements Strategy {

    private Random random;

    private int currentHandValue;

    private int prevHandValue;

    private int[][] history = {
        {1, 1, 1},
        {1, 1, 1},
        {1, 1, 1}
    };

    public ProbStrategy(int seed) {
        random = new Random(seed);
    }

    @Override
    public Hand nextHand() {
        int bet = random.nextInt(getSum(currentHandValue));
        int handValue;
        if (bet < history[currentHandValue][0]) {
            handValue = 0;
        } else if (bet < history[currentHandValue][0] + history[currentHandValue][1]) {
            handValue = 1;
        } else {
            handValue = 2;
        }
        prevHandValue = currentHandValue;
        currentHandValue = handValue;
        return Hand.getHand(handValue);
    }

    @Override
    public void study(boolean win) {
        if (win) {
            history[prevHandValue][currentHandValue]++;
        } else {
            history[prevHandValue][(currentHandValue + 1) % 3]++;
            history[prevHandValue][(currentHandValue + 2) % 3]++;
        }
    }

    private int getSum(int handValue) {
        int sum = 0;
        for (int i = 0; i < history[handValue].length; i++) {
            sum += history[handValue][i];
        }
        return sum;
    }
}
