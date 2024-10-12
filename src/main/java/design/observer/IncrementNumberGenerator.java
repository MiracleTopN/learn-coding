package design.observer;

/**
 * @author hason
 * @since 2023/6/29 14:29
 */
public class IncrementNumberGenerator extends NumberGenerator {

    private int end;

    private int step;

    private int number;

    public IncrementNumberGenerator(int start, int end, int step) {
        this.number = start;
        this.end = end;
        this.step = step;
    }

    @Override
    public int getNumber() {
        return this.number;
    }

    @Override
    public void execute() {
        while (this.number < end) {
            this.number += step;
            notifyObservers();
        }
    }
}
