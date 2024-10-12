package design.observer;

/**
 * ConcreteObserver 具体的观察者
 * @author hason
 * @since 2023/6/28 20:12
 */
public class DigitalObserver implements Observer {
    @Override
    public void update(NumberGenerator generator) {
        System.out.println("DigitalObserver:" + generator.getNumber());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
