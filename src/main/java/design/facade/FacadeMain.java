package design.facade;

/**
 * Facade模式将Api接口变少了 同时也意味着程序与外部的关系弱化了(这将方便包作为一个整体作为组件被复用)
 * @author hason
 * @since 2023/6/26 22:34
 */
public class FacadeMain {

    public static void main(String[] args) {
        PageMaker.makeWelcomePage("hyuki@hyuki.com", "welcome.html");
        PageMaker.makeLinkPage("linkPage.html");
    }

}
