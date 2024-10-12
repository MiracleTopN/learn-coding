package design.composite;

/**
 * @author hason
 * @since 2023/6/13 15:03
 */
public abstract class Entry {

    private Entry parent;

    public abstract String getName();

    public abstract int getSize();

    public Entry add(Entry entry) throws FileTreatmentException {
        throw new FileTreatmentException();
    }

    public abstract void printList(String prefix);

    @Override
    public String toString() {
        return getName() + "(" + getSize() + ")";
    }

    public void setParent(Entry parent) {
        this.parent = parent;
    }

    public String getFullName() {
        StringBuffer bf = new StringBuffer();
        Entry entry = this;
        do {
            bf.insert(0, "/" + entry.getName());
            entry = entry.parent;
        } while (entry != null);
        return bf.toString();
    }

}
