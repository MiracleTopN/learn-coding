package design.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author hason
 * @since 2023/6/13 15:10
 */
public class Directory extends Entry {

    private String name;

    private List<Entry> list = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        int size = 0;
        Iterator<Entry> it = list.listIterator();
        while (it.hasNext()) {
            size += it.next().getSize();
        }
        return size;
    }

    @Override
    public Entry add(Entry entry) {
        list.add(entry);
        entry.setParent(this);
        return this;
    }

    @Override
    public void printList(String prefix) {
        System.out.println(prefix + "/" + this);
        Iterator<Entry> it = list.listIterator();
        while (it.hasNext()) {
            it.next().printList(prefix + "/" + name);
        }
    }
}
