package design.visitor;

import design.visitor.common.Entry;
import design.visitor.common.Visitor;

/**
 * @author hason
 * @since 2023/6/23 00:09
 */
public class File extends Entry {

    private String name;

    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
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
        return size;
    }
}
