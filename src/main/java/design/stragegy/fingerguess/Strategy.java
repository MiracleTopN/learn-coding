package design.stragegy.fingerguess;

/**
 * @author hason
 * @since 2023/6/10
 */
public interface Strategy {

    Hand nextHand();

    void study(boolean win);

}
