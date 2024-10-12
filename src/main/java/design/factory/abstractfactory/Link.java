package design.factory.abstractfactory;

/**
 * @author hason
 * @since 2023/6/7 10:51
 */
public abstract class Link extends Item {

    protected String url;

    public Link(String caption, String url) {
        super(caption);
        this.url = url;
    }
}
