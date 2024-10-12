package design.iterator;

/**
 * Iterator模式
 * 
 * Iterator 迭代器
 * ConcreteIterator 具体的迭代器(BookShelfIterator)
 * Aggregate 集合
 * ConcreteAggregate 具体的集合(BookShelf)
 * 
 * @author hason
 * @since 2023/9/12 23:24
 */
public class IteratorMain {

    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.appendBook(new Book("Around the World in 80 days"));
        bookShelf.appendBook(new Book("Bible"));
        bookShelf.appendBook(new Book("Cinderella"));
        bookShelf.appendBook(new Book("Daddy-Long-Legs"));
        Iterator<Book> it = bookShelf.iterator();
        while (it.hasNext()) {
            Book book = it.next();
            System.out.println(book.getName());
        }
    }

}
