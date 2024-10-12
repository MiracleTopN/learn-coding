package design.visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import design.visitor.common.Entry;
import design.visitor.common.Visitor;

/**
 * @author hason
 * @since 2023/6/23 01:33
 */
public class FileFindVisitor extends Visitor {

    private List<File> fileWithSuffix = new ArrayList<>();

    private String suffix;

    public FileFindVisitor(String suffix) {
        this.suffix = suffix;
    }

    @Override
    public void visit(File file) {
        if (file.getName().endsWith(suffix)) {
            fileWithSuffix.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        Iterator<Entry> iterator = directory.iterator();
        while (iterator.hasNext()) {
            Entry entry = iterator.next();
            entry.accept(this);
        }
    }

    public Iterator<File> getFoundFiles() {
        return fileWithSuffix.iterator();
    }

}
