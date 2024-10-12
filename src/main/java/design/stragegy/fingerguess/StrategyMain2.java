package design.stragegy.fingerguess;

/**
 * @author hason
 * @since 2023/6/11 14:54
 */
public class StrategyMain2 {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage : java Main randomSeed1 randomSeed2");
            System.out.println("Example : java Main 320 15");
            System.exit(0);
        }
        int seed1 = Integer.parseInt(args[0]);
        int seed2 = Integer.parseInt(args[1]);
        Player p1 = new Player("Player1", new RandomStrategy(seed1));
        Player p2 = new Player("Player2", new ProbStrategy(seed2));
        for (int i = 0; i < 1000; i++) {
            Hand nextHand1 = p1.nextHand();
            Hand nextHand2 = p2.nextHand();
            if (nextHand1.isStrongerThan(nextHand2)) {
                System.out.println("Winner is " + p1);
                p1.win();
                p2.lose();
            } else if (nextHand1.isWeakerThan(nextHand2)) {
                System.out.println("Winner is " + p2);
                p1.lose();
                p2.win();
            } else {
                System.out.println("Even...");
                p1.even();
                p2.even();
            }
            System.out.println("total result is :");
            System.out.println(p1);
            System.out.println(p2);
        }
    }
}
