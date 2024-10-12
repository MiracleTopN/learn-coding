package design.visitor;

import java.util.ArrayList;
import java.util.Iterator;

import design.visitor.common.Element;
import design.visitor.common.Entry;
import design.visitor.common.FileTreatmentException;
import design.visitor.common.Visitor;

/**
 * @author hason
 * @since 2023/6/24 15:07
 */
public class ElementArrayList extends ArrayList<Entry> implements Element {
    @Override
    public void accept(Visitor v) {
        Iterator<Entry> iterator = iterator();
        while (iterator.hasNext()) {
            Entry next = iterator.next();
            next.accept(v);
        }
    }

    public static void main(String[] args) {
        try {
            Directory root1 = new Directory("root1");
            root1.add(new File("diary.html", 10));
            root1.add(new File("index.html", 20));

            Directory root2 = new Directory("root2");
            root2.add(new File("diary.html", 1000));
            root2.add(new File("index.html", 2000));

            ElementArrayList list = new ElementArrayList();
            list.add(root1);
            list.add(root2);
            list.add(new File("etc.html", 1234));

            list.accept(new ListVisitor());

        } catch (FileTreatmentException e) {
            e.printStackTrace();
        }
    }

}
