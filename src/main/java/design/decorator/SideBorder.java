package design.decorator;

/**
 * 外边框
 * @author hason
 * @since 2023/6/16 18:47
 */
public class SideBorder extends Border {

    private char borderChar;

    public SideBorder(Display displayImpl, char ch) {
        super(displayImpl);
        this.borderChar = ch;
    }

    @Override
    public int getColumns() {
        return 1 + displayImpl.getColumns() + 1;
    }

    @Override
    public int getRows() {
        return displayImpl.getRows();
    }

    @Override
    public String getRowText(int row) {
        return borderChar + displayImpl.getRowText(row) + borderChar;
    }
}
