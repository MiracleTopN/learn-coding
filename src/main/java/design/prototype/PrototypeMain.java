package design.prototype;

/**
 * Prototype模式
 * 优点: 可以不根据类名来生成对象
 *     1.无法整合到一个类的对象
 *     2.难以生成的对象 比如成员变量很多的实例
 *     3.解耦框架与生成的实例 不借助new XXX()来生成实例 可以将框架从类名的束缚中解脱出来
 *        -组件复用: 不改变源代码的基础上复用组件——如果与类名耦合 那么框架的可扩展性就减弱 不易替换代码；而通过类名以参数的形式生成实例，那么将很容易替换代码
 * 另外: 
 *     1.实现Cloneable接口的类可以调用clone()方法进行复制，但clone()方法属于Object类，实现Cloneable接口只是标记的作用
 *     2.实现Cloneable接口的类只是浅复制(shallow copy)，也就是说复制出来的类中的成员变量的引用依然是被复制类的成员变量的引用(field-to-field copy)
 * @author hason
 * @since 2023/6/5 14:34
 */
public class PrototypeMain {

    public static void main(String[] args) {
        Manager manager = new Manager();
        Product mBox = new MessageBox('*');
        Product sBox = new MessageBox('/');
        Product underlinePen = new UnderlinePen('~');
        manager.registerProduct("mbox", mBox);
        manager.registerProduct("sbox", sBox);
        manager.registerProduct("underlinepen", underlinePen);

        Product p1 = manager.createProduct("mbox");
        p1.use("i am mbox");
        Product p2 = manager.createProduct("sbox");
        p2.use("i am sbox");
        Product p3 = manager.createProduct("underlinepen");
        p3.use("i am uderline pen");

    }
}
