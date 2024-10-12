package design.visitor.common;

/**
 * @author hason
 * @since 2023/6/23 00:00
 */
public interface Element {

    void accept(Visitor v);

}
