package design.decorator;

/**
 * @author hason
 * @since 2023/6/16 19:59
 */
public class DecoratorMain {

    public static void main(String[] args) {
        Display b1 = new StringDisplay("Hello , world.");
        b1.show();
        Display b2 = new SideBorder(b1, '#');
        b2.show();
        Display b3 = new FullBorder(b1);
        b3.show();
        // 递归
        Display b4 = new SideBorder(
                new FullBorder(new FullBorder(new SideBorder(new FullBorder(new StringDisplay("hi,siri")), '*'))),
                '/');
        b4.show();
        Display b5 = new FullBorder(new UpDownBorder(
                new SideBorder(new UpDownBorder(new SideBorder(new StringDisplay("hello world!!!"), '*'), '='), '|'),
                '/'));
        b5.show();
        MultiStringDisplay b6 = new MultiStringDisplay();
        b6.add("早上好");
        b6.add("中午好");
        b6.add("晚安,明天见");
        b6.show();
        Display b7 = new SideBorder(b6, '#');
        b7.show();
        Display b8 = new FullBorder(b6);
        b8.show();
    }

}
