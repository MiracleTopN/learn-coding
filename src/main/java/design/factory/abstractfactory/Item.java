package design.factory.abstractfactory;

/**
 * @author hason
 * @since 2023/6/7 10:50
 */
public abstract class Item implements HTMLList {

    protected String caption;

    public Item(String caption) {
        this.caption = caption;
    }

}
