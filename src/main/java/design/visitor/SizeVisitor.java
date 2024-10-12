package design.visitor;

import java.util.Iterator;

import design.visitor.common.Entry;
import design.visitor.common.Visitor;

/**
 * @author hason
 * @since 2023/6/24 14:53
 */
public class SizeVisitor extends Visitor {

    private int size;

    @Override
    public void visit(File file) {
        size += file.getSize();
    }

    @Override
    public void visit(Directory directory) {
        Iterator<Entry> it = directory.iterator();
        while (it.hasNext()) {
            Entry next = it.next();
            next.accept(this);
        }
    }

    public int getSize() {
        return size;
    }

}
