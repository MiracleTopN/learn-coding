package design.observer;

/** 
 * 观察者模式
 * @author hason
 * @since 2023/6/28 20:16
 */
public class ObserverMain {

    public static void main(String[] args) {
        NumberGenerator randomGenerator = new RandomNumberGenerator();
        Observer observer1 = new DigitalObserver();
        Observer observer2 = new GraphObserver();
        Observer observer3 = new FrameObserver();
        randomGenerator.addObserver(observer1);
        randomGenerator.addObserver(observer2);
        randomGenerator.addObserver(observer3);
        randomGenerator.execute();

        NumberGenerator incrementGenerator = new IncrementNumberGenerator(10, 50, 5);
        incrementGenerator.addObserver(observer1);
        incrementGenerator.addObserver(observer2);
        incrementGenerator.execute();

    }

}
