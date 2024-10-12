package design.factory.abstractfactory.sub;

import design.factory.abstractfactory.Factory;
import design.factory.abstractfactory.Link;
import design.factory.abstractfactory.Page;
import design.factory.abstractfactory.Tray;

/**
 * @author hason
 * @since 2023/6/7 14:17
 */
public class ListFactory extends Factory {
    @Override
    public Link createLink(String captain, String url) {
        return new ListLink(captain, url);
    }

    @Override
    public Tray createTray(String captain) {
        return new ListTray(captain);
    }

    @Override
    public Page createPage(String title, String author) {
        return new ListPage(title, author);
    }
}
