package design.builder;

/**
 * @author hason
 * @since 2023/6/6 01:53
 */
public abstract class AbstractBuilder implements Builder {

    private int initialSignal;

    @Override
    public void makeTitle(String title) {
        if (initialSignal == 0) {
            buildTitle(title);
            initialSignal = 1;
        }
    }

    @Override
    public void makeString(String str) {
        if (initialSignal == 1) {
            buildString(str);
        }
    }

    @Override
    public void makeItems(String[] items) {
        if (initialSignal == 1) {
            buildItems(items);
        }
    }

    @Override
    public void close() {
        if (initialSignal == 1) {
            doClose();
        }
    }

    public abstract void buildTitle(String title);

    public abstract void buildString(String str);

    public abstract void buildItems(String[] items);

    public abstract void doClose();

}
