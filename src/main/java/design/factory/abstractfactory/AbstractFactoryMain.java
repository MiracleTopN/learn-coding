package design.factory.abstractfactory;

/**
 * @author hason
 * @since 2023/6/7 14:16
 */
public class AbstractFactoryMain {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage : java AbstractFactoryMain class.name.of.ConcreteFactory");
            System.out.println("Example : java AbstractFactoryMain design.factory.abstractfactory.sub.ListFactory");
            System.exit(1);
        }
        Factory factory = Factory.getFactory(args[0]);
        Link people = factory.createLink("人民日报", "http://www.people.com.cn/");
        Link gmw = factory.createLink("光明日报", "http://www.gmw.cn.");

        Link us_yahoo = factory.createLink("Yahoo", "http://www.yahoo.com/");
        Link yp_yahho = factory.createLink("Yahoo Japan", "http://www.yahoo.co.jp/");
        Link excite = factory.createLink("Excite", "http://www.excite.com/");
        Link google = factory.createLink("Google", "http://www.google.com/");

        Tray trayNews = factory.createTray("日报");
        trayNews.add(people);
        trayNews.add(gmw);

        Tray trayyahoo = factory.createTray("Yahoo");
        trayyahoo.add(us_yahoo);
        trayyahoo.add(yp_yahho);

        Tray traysearch = factory.createTray("检索引擎");
        traysearch.add(trayyahoo);
        traysearch.add(excite);
        traysearch.add(google);

        Page page = factory.createPage("LinkPage", "hason");
        page.add(trayNews);
        page.add(traysearch);
        page.output();
    }

}
