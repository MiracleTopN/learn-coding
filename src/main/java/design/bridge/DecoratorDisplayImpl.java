package design.bridge;

/** 实现层次
 * @author hason
 * @since 2023/6/8 22:16
 */
public class DecoratorDisplayImpl implements DisplayImpl {

    private String head;

    private String mid;

    private String tail;

    public DecoratorDisplayImpl(String head, String mid, String tail) {
        this.head = head;
        this.mid = mid;
        this.tail = tail;
    }

    @Override
    public void rawOpen() {
        System.out.print(head);
    }

    @Override
    public void rawPrint() {
        System.out.print(mid);
    }

    @Override
    public void rawClose() {
        System.out.println(tail);
    }

}
