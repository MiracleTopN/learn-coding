package design.responsibility;

/**
 * 只解决指定编号
 * @author hason
 * @since 2023/6/26 00:34
 */
public class OddSupport extends Support {

    public OddSupport(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if (trouble.getNumber() % 2 == 1) {
            return true;
        }
        return false;
    }
}
