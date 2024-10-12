package design.builder;

/**
 * @author hason
 * @since 2023/6/6 00:50
 */
public class BuilderMain {

    public static final String PLAIN = "plain";

    public static final String HTML = "html";

    public static void main(String[] args) {
        if (args.length != 1) {
            usage();
            System.exit(0);
        }
        if (PLAIN.equals(args[0])) {
            TextBuilder textBuilder = new TextBuilder();
            Director director = new Director(textBuilder);
            director.construct();
            String result = textBuilder.getResult();
            System.out.println(result);
        } else if (HTML.equals(args[0])) {
            HTMLBuilder htmlBuilder = new HTMLBuilder();
            Director director = new Director(htmlBuilder);
            director.construct();
            String fileName = htmlBuilder.getResult();
            System.out.println(fileName + "文档编写完成");
        } else {
            usage();
            System.exit(0);
        }

    }

    private static void usage() {
        System.out.println("Usage: java Main plain");
        System.out.println("Usage: java Main html");
    }
}
