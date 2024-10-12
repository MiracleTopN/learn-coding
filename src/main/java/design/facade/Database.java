package design.facade;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 该类权限为 包访问权限 
 * 目的是将整个包作为一个整体组件提供给外部 外部只能通过Facade类来调用
 *
 * @author hason
 * @since 2023/6/26 21:59
 */
class Database {

    private Database() {

    }

    public static Properties getProperties(String dbname) {
        String filename = dbname + ".txt";
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(filename));
        } catch (IOException e) {
            System.out.println("Warning :" + filename + "is not found");
        }
        return prop;
    }

}
