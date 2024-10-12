package design.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * FlyweightFactory 轻量级工厂:负责生成Flyweight实例并存储 以实现实例共享
 * @author hason
 * @since 2023/7/5 00:40
 */
public class BigCharFactory {

    // 负责存储已经生成的对象
    private Map<String, BigChar> pool = new HashMap();

    private static BigCharFactory bigCharFactory = new BigCharFactory();

    private BigCharFactory() {

    }

    public static BigCharFactory getInstance() {
        return bigCharFactory;
    }

    // 核心方法
    // 使用锁是防止在多线程环境下同一个charname的实例生成多次 这样是对系统资源的浪费
    public synchronized BigChar getBigChar(char charname) {
        BigChar bc = pool.get("" + charname);
        if (null == bc) {
            bc = new BigChar(charname);
            pool.put("" + charname, bc);
        }
        return bc;
    }

}
