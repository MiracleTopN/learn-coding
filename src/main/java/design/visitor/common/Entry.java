package design.visitor.common;

import java.util.Iterator;

/**
 * @author hason
 * @since 2023/6/23 00:01
 */
public abstract class Entry implements Element {

    public abstract String getName();

    public abstract int getSize();

    public Entry add(Entry entry) throws FileTreatmentException {
        throw new FileTreatmentException();
    }

    public Iterator iterator() throws FileTreatmentException {
        throw new FileTreatmentException();
    }

    @Override
    public String toString() {
        return getName() + "(" + getSize() + ")";
    }

}
