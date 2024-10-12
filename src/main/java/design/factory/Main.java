package design.factory;

/**
 * @author hason
 * @since 2023/6/4 18:21
 */
public class Main {

    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("product1");
        Product card2 = factory.create("product2");
        Product card3 = factory.create("product2");
        card1.use();
        card2.use();
        card3.use();
    }
}
