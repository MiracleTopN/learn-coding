package design.factory;

/**
 * @author hason
 * @since 2023/6/4 17:56
 */
public abstract class Factory {

    public final Product create(String owner) {
        Product p = createProduct(owner);
        registerProduct(p);
        return p;
    }

    public abstract Product createProduct(String owner);

    public abstract void registerProduct(Product p);
}
