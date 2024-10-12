package design.responsibility;

/**
 * @author hason
 * @since 2023/6/26 00:24
 */
public class Trouble {

    private int number;

    public Trouble(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "[Trouble" + number + "]";
    }

}
