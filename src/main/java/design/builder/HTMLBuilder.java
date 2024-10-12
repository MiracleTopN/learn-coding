package design.builder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author hason
 * @since 2023/6/6 00:43
 */
public class HTMLBuilder extends AbstractBuilder {

    private String fileName;
    private PrintWriter writer;

    @Override
    public void buildTitle(String title) {
        fileName = title + ".html";
        try {
            writer = new PrintWriter(new FileWriter(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        writer.println("<html><head><title>" + title + "</title></head><body>");
        writer.println("<h1>" + title + "</h1>");
    }

    @Override
    public void buildString(String str) {
        writer.println("<p>" + str + "</p>");
    }

    @Override
    public void buildItems(String[] items) {
        writer.println("<u1>");
        for (int i = 0; i < items.length; i++) {
            writer.println("<li>" + items[i] + "</li>");
        }
        writer.println("</u1>");
    }

    @Override
    public void doClose() {
        writer.println("</body></html>");
        writer.close();
    }

    public String getResult() {
        return fileName;
    }
}
