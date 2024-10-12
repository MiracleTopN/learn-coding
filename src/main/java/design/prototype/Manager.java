package design.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hason
 * @since 2023/6/5 13:53
 */
public class Manager {

    private Map<String, Product> cache = new HashMap<>();

    public void registerProduct(String key, Product p) {
        cache.put(key, p);
    }

    public Product createProduct(String key) {
        Product product = cache.get(key);
        if (null == product) {
            return null;
        }
        return product.createProduct();
    }
}
