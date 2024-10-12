package design.stragegy.fingerguess;

/**
 * @author hason
 * @since 2023/6/10 17:13
 */
public class Player {

    private String name;

    private Strategy strategy;

    private int loseCount;

    private int winCount;

    private int evenCount;

    private int gameCount;

    public Player(String name, Strategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }

    public Hand nextHand() {
        return strategy.nextHand();
    }

    public void win() {
        strategy.study(true);
        winCount++;
        gameCount++;
    }

    public void lose() {
        strategy.study(false);
        loseCount++;
        gameCount++;
    }

    public void even() {
        evenCount++;
        gameCount++;
    }

    @Override
    public String toString() {
        return "Player{" + "name='" + name + '\'' + ", loseCount=" + loseCount + ", winCount=" + winCount
                + ", evenCount=" + evenCount + ", gameCount=" + gameCount + '}';
    }
}
