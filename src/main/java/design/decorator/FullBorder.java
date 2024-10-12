package design.decorator;

/**
 * @author hason
 * @since 2023/6/16 18:54
 */
public class FullBorder extends Border {

    public FullBorder(Display displayImpl) {
        super(displayImpl);
    }

    @Override
    public int getColumns() {
        return 1 + displayImpl.getColumns() + 1;
    }

    @Override
    public int getRows() {
        return 1 + displayImpl.getRows() + 1;
    }

    @Override
    public String getRowText(int row) {
        if (row == 0) {
            return "+" + makeLine('-', displayImpl.getColumns()) + "+";
        } else if (row == displayImpl.getRows() + 1) {
            return "+" + makeLine('-', displayImpl.getColumns()) + '+';
        }
        return "|" + displayImpl.getRowText((row - 1)) + "|";
    }

    private String makeLine(char ch, int count) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < count; i++) {
            buf.append(ch);
        }
        return buf.toString();
    }

}
