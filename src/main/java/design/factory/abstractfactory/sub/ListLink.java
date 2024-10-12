package design.factory.abstractfactory.sub;

import design.factory.abstractfactory.Link;

/**
 * @author hason
 * @since 2023/6/7 11:41
 */
public class ListLink extends Link {
    public ListLink(String caption, String url) {
        super(caption, url);
    }

    @Override
    public String makeHTML() {
        return " <li><a href=\"" + url + "\">" + caption + "</a></li>\n";
    }
}
