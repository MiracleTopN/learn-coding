package design.responsibility;

/**
 * @author hason
 * @since 2023/6/26 00:32
 */
public class NoSupport extends Support {

    public NoSupport(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        return false;
    }
}
