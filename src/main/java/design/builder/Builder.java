package design.builder;

/**
 * @author hason
 * @since 2023/6/6 00:33
 */
public interface Builder {

    void makeTitle(String title);

    void makeString(String str);

    void makeItems(String[] items);

    void close();
}
