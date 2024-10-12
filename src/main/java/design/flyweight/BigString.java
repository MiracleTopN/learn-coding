package design.flyweight;

/**
 * client角色:使用FlyweightFactory来生成Flyweight实例
 * @author hason
 * @since 2023/7/5 00:51
 */
public class BigString {

    private BigChar[] bigChars;

    public BigString(String string, boolean shared) {
        if (shared) {
            initShared(string);
        } else {
            initUnShared(string);
        }
    }

    private void initShared(String string) {
        bigChars = new BigChar[string.length()];
        BigCharFactory bigCharFactory = BigCharFactory.getInstance();
        for (int i = 0; i < bigChars.length; i++) {
            // 将BigChar生成好以备用
            bigChars[i] = bigCharFactory.getBigChar(string.charAt(i));
        }
    }

    private void initUnShared(String string) {
        bigChars = new BigChar[string.length()];
        for (int i = 0; i < bigChars.length; i++) {
            // 不使用factory进行共享 直接生成
            bigChars[i] = new BigChar(string.charAt(i));
        }
    }

    public void print() {
        for (int i = 0; i < bigChars.length; i++) {
            bigChars[i].print();
        }
    }

}
