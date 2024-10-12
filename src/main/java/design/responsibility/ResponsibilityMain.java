package design.responsibility;

/**
 * 责任链模式
 * 优点：1.弱化了请求人与被请求人之间的关系
 *      2.可以动态的改变责任链 
 *      3.专注自己的工作
 * 缺点：会导致延迟
 * @author hason
 * @since 2023/6/26 00:36
 */
public class ResponsibilityMain {

    public static void main(String[] args) {
        Support alice = new NoSupport("Alice");
        Support bob = new LimitSupport("Bob", 100);
        Support charlie = new SpecialSupport("Chailie", 429);
        Support diana = new LimitSupport("Diana", 200);
        Support elmo = new OddSupport("Elmo");
        Support fred = new LimitSupport("Fred", 300);

        alice.setNext(bob).setNext(charlie).setNext(diana).setNext(elmo).setNext(fred);
        for (int i = 0; i < 500; i++) {
            alice.support(new Trouble(i));
        }
        for (int i = 1; i < 500; i++) {
            alice.supportNoRecursion(new Trouble(i));
        }
        for (int i = 1; i < 500; i++) {
            alice.supportNoRecursion1(new Trouble(i));
        }
    }

}
