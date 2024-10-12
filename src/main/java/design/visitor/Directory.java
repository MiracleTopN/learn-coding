package design.visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import design.visitor.common.Entry;
import design.visitor.common.Visitor;

/**
 * @author hason
 * @since 2023/6/23 00:11
 */
public class Directory extends Entry {

    private String name;

    private List<Entry> dir = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        // 用SizeVisitor来计算size
        SizeVisitor v = new SizeVisitor();
        accept(v);
        return v.getSize();
//        int size = 0;
//        Iterator<Entry> iterator = dir.iterator();
//        while (iterator.hasNext()) {
//            Entry entry = iterator.next();
//            size += entry.getSize();
//        }
//        return size;
    }

    @Override
    public Iterator<Entry> iterator() {
        return dir.iterator();
    }

    @Override
    public Entry add(Entry entry) {
        dir.add(entry);
        return this;
    }

}
