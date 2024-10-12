package design.facade;

import java.io.IOException;
import java.io.Writer;

/**
 * 该类权限为 包访问权限
 * 目的是将整个包作为一个整体组件提供给外部 外部只能通过Facade类来调用
 * @author hason
 * @since 2023/6/26 22:09
 */
class HtmlWriter {

    private Writer writer;

    public HtmlWriter(Writer writer) {
        this.writer = writer;
    }

    public void title(String title) throws IOException {
        writer.write("<html>");
        writer.write("<head>");
        writer.write("<title>" + title + "</title>");
        writer.write("</head>");
        writer.write("<body>\n");
        writer.write("<h1>" + title + "</h1>\n");
    }

    public void paragraph(String msg) throws IOException {
        writer.write("<p>" + msg + "</p>\n");
    }

    public void link(String href, String caption) throws IOException {
        paragraph("<a href= \"" + href + "\">" + caption + "</a>");
    }

    public void mailto(String mailAddress, String username) throws IOException {
        link("mailto:" + mailAddress, username);
    }

    public void close() throws IOException {
        writer.write("</body>");
        writer.write("</html>\n");
        writer.close();
    }

}
