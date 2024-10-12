package design.visitor;

import java.util.Iterator;

import design.visitor.common.Entry;
import design.visitor.common.Visitor;

/**
 * @author hason
 * @since 2023/6/23 00:14
 */
public class ListVisitor extends Visitor {

    private String currentDir = "";

    @Override
    public void visit(File file) {
        System.out.println(currentDir + "/" + file);
    }

    @Override
    public void visit(Directory directory) {
        System.out.println(currentDir + "/" + directory);
        String saveDir = currentDir;
        currentDir = currentDir + "/" + directory.getName();
        Iterator<Entry> iterator = directory.iterator();
        while (iterator.hasNext()) {
            Entry entry = iterator.next();
            entry.accept(this);
        }
        currentDir = saveDir;
    }
}
