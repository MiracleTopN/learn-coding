package design.factory.abstractfactory;

/**
 * @author hason
 * @since 2023/6/7 15:04
 */
public class AbstractFactoryYahooMain {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage : java AbstractFactoryMain class.name.of.ConcreteFactory");
            System.out.println("Example : java AbstractFactoryMain design.factory.abstractfactory.sub.ListFactory");
            System.exit(1);
        }
        Factory factory = Factory.getFactory(args[0]);
        Page page = factory.createYahooPage();
        page.output();
    }
}
