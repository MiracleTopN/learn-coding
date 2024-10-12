package design.prototype;

/**
 * @author hason
 * @since 2023/6/5 14:22
 */
public abstract class Product implements Cloneable {

    public abstract void use(String s);

    public Product createProduct() {
        Product p = null;
        try {
            p = (Product)clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }

}
