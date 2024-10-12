package design.visitor.common;

import design.visitor.Directory;
import design.visitor.File;

/**
 * @author hason
 * @since 2023/6/22 23:58
 */
public abstract class Visitor {

    public abstract void visit(File file);

    public abstract void visit(Directory directory);

}
