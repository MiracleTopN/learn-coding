package design.bridge;

/**
 * 桥接模式
 * Abstraction 抽象化(Display)
 * RefinedAbstraction 改善后的抽象化(CountDisplay，RandomDisplay) 类的功能层次
 * Implementor 实现者(DisplayImpl)
 * ConcreteImplementor 具体实现者(DecoratorDisplayImpl、FileDisplayImpl、StringDisplayImpl) 类的实现层次
 * 
 * @author hason
 * @since 2023/6/8 14:24
 */
public class BridgeMain {

    public static void main(String[] args) {
        Display display1 = new Display(new StringDisplayImpl("Hello , Java"));
        Display display2 = new Display(new StringDisplayImpl("Hello , World"));
        CountDisplay display3 = new CountDisplay(new StringDisplayImpl("Hello , China"));
        RandomDisplay display4 = new RandomDisplay(new StringDisplayImpl("Hello , Random"));
        Display display5 = new Display(new FileDisplayImpl("Myfile.txt"));
        StepCountDisplay display6 = new StepCountDisplay(new DecoratorDisplayImpl("<", "*", ">"), 2);
        display1.display();
        display2.display();
        display3.multiDisplay(5);
        display4.randomDisplay(10);
        display5.display();
        display6.stepMultiDisplay(5);
    }
}
