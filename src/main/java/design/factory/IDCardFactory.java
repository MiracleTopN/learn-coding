package design.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hason
 * @since 2023/6/4 18:08
 */
public class IDCardFactory extends Factory {

    private Map<Integer, Product> database = new HashMap<>();

    int serialNo = 100;

    @Override
    public synchronized Product createProduct(String owner) {
        return new IDCard(owner, serialNo++);
    }

    @Override
    public void registerProduct(Product p) {
        IDCard idCard = (IDCard)p;
        database.put(idCard.getSerialNo(), idCard);
    }
}
