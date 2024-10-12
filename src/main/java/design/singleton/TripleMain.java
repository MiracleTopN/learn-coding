package design.singleton;

/**
 * @author hason
 * @since 2023/6/4 23:05
 */
public class TripleMain {

    public static void main(String[] args) {

        for (int i = 0; i < 9; i++) {
            Triple triple = Triple.getInstance(i % 3);
            System.out.println("result is " + triple.getSerial());
        }
    }
}
