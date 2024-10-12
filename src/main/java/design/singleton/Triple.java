package design.singleton;

/**
 * @author hason
 * @since 2023/6/4 22:57
 */
public class Triple {

    private static Triple[] triples = new Triple[3];

    private int serial;

    private Triple(int serial) {
        this.serial = serial;
    }

    static {
        triples[0] = new Triple(0);
        triples[1] = new Triple(1);
        triples[2] = new Triple(2);
    }

    public static Triple getInstance(int serial) {
        if (serial > triples.length) {
            return null;
        }
        return triples[serial];
    }

    public int getSerial() {
        return serial;
    }
}
