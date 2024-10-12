package design.factory.abstractfactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hason
 * @since 2023/6/7 10:50
 */
public abstract class Tray extends Item {

    protected List<Item> trays = new ArrayList<>();

    public Tray(String caption) {
        super(caption);
    }

    public void add(Item item) {
        trays.add(item);
    }
}
