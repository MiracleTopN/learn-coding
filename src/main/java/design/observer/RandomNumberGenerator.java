package design.observer;

import java.util.Random;

/**
 * ConcreteSubject 具体的被观察者
 * @author hason
 * @since 2023/6/28 20:09
 */
public class RandomNumberGenerator extends NumberGenerator {

    private Random random = new Random();

    private int number;

    @Override
    public int getNumber() {
        return this.number;
    }

    @Override
    public void execute() {
        for (int i = 0; i < 20; i++) {
            this.number = random.nextInt(20);
            notifyObservers();
        }
    }
}
