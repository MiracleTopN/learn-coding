package design.factory.abstractfactory;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hason
 * @since 2023/6/7 10:53
 */
public abstract class Page implements HTMLList {

    protected String title;

    protected String author;

    protected List<Item> content = new ArrayList<>();

    public Page(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void add(Item item) {
        content.add(item);
    }

    public void output() {
        String filename = title + ".html";
        Writer writer;
        try {
            writer = new FileWriter(filename);
            writer.write(this.makeHTML());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
