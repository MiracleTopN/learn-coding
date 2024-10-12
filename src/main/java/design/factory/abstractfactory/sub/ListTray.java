package design.factory.abstractfactory.sub;

import java.util.Iterator;

import design.factory.abstractfactory.Item;
import design.factory.abstractfactory.Tray;

/**
 * @author hason
 * @since 2023/6/7 11:41
 */
public class ListTray extends Tray {

    public ListTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHTML() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<li>\n");
        buffer.append(caption + "\n");
        buffer.append("<ul>\n");
        Iterator it = trays.listIterator();
        while (it.hasNext()) {
            Item item = (Item)it.next();
            // 递归调用
            buffer.append(item.makeHTML());
        }
        buffer.append("</ul>\n");
        buffer.append("</li>\n");
        return buffer.toString();
    }
}
