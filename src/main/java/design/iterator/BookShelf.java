package design.iterator;

/**
 * @author hason
 * @since 2023/9/12 23:01
 */
public class BookShelf implements Aggregate {

    private Book[] books;

    private int last = 0;

    public BookShelf(int maxSize) {
        books = new Book[maxSize];
    }

    public Book getBookAt(int index) {
        return books[index];
    }

    public void appendBook(Book book) {
        this.books[last] = book;
        last++;
    }

    public int getLength() {
        return last;
    }

    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}
