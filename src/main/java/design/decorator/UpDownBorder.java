package design.decorator;

/**
 * @author hason
 * @since 2023/6/16 21:59
 */
public class UpDownBorder extends Border {

    private char ch;

    public UpDownBorder(Display displayImpl, char ch) {
        super(displayImpl);
        this.ch = ch;
    }

    @Override
    public int getColumns() {
        return displayImpl.getColumns();
    }

    @Override
    public int getRows() {
        return 1 + displayImpl.getRows() + 1;
    }

    @Override
    public String getRowText(int row) {
        if (row == 0 || row == displayImpl.getRows() + 1) {
            return makeLine();
        }
        return displayImpl.getRowText(row - 1);
    }

    private String makeLine() {
        int columns = displayImpl.getColumns();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < columns; i++) {
            stringBuffer.append(ch);
        }
        return stringBuffer.toString();
    }

}
