package design.factory.abstractfactory;

import java.lang.reflect.InvocationTargetException;

/**
 * @author hason
 * @since 2023/6/7 10:48
 */
public abstract class Factory {

    public static Factory getFactory(String className) {
        Factory factory = null;
        try {
            factory = (Factory)Class.forName(className).getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return factory;
    }

    public abstract Link createLink(String captain, String url);

    public abstract Tray createTray(String captain);

    public abstract Page createPage(String title, String author);

    public Page createYahooPage() {
        Link link = createLink("Yahoo", "http://www.yahoo.com/");
        Page page = createPage("Yahoo", "Yahoo");
        page.add(link);
        return page;
    }

}
