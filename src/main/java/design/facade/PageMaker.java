package design.facade;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Facade角色
 * @author hason
 * @since 2023/6/26 22:19
 */
public class PageMaker {

    private PageMaker() {}

    public static void makeWelcomePage(String mailAddress, String fileName) {
        Properties mailprop = Database.getProperties("maildata");
        String username = mailprop.getProperty(mailAddress);
        try {
            // 装饰器模式
            HtmlWriter writer = new HtmlWriter(new FileWriter(fileName));
            writer.title("Welcome to " + username + "`s page");
            writer.paragraph(username + "欢迎来到" + username + "的主页");
            writer.paragraph("等你的邮件哦！");
            writer.mailto(mailAddress, username);
            writer.close();
            System.out.println(fileName + " is created for" + mailAddress + "(" + username + ")");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void makeLinkPage(String fileName) {
        try {
            HtmlWriter writer = new HtmlWriter(new FileWriter(fileName));
            writer.title("Link page");
            Properties mailprop = Database.getProperties("maildata");
            Enumeration<?> enumeration = mailprop.propertyNames();
            while (enumeration.hasMoreElements()) {
                String mailAddress = enumeration.nextElement().toString();
                String userName = mailprop.getProperty(mailAddress);
                writer.mailto(mailAddress, userName);
            }
            writer.close();
            System.out.println(fileName + " is created");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
