package design.decorator;

/**    
 * 被装饰物
 * @author hason
 * @since 2023/6/16 18:41
 */
public class StringDisplay extends Display {

    private String str;

    public StringDisplay(String str) {
        this.str = str;
    }

    @Override
    public int getColumns() {
        return str.length();
    }

    @Override
    public int getRows() {
        return 1;
    }

    @Override
    public String getRowText(int row) {
        if (row == 0) {
            return str;
        }
        return null;
    }
}
