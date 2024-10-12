package design.iterator;

/**
 * @author hason
 * @since 2023/9/12 23:00
 */
public interface Iterator<T> {

    boolean hasNext();

    T next();
}
