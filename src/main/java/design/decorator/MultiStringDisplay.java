package design.decorator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hason
 * @since 2023/6/16 23:42
 */
public class MultiStringDisplay extends Display {

    private List<String> strList = new ArrayList<>();

    private int columns;

    @Override
    public int getColumns() {
        return columns;
    }

    @Override
    public int getRows() {
        return strList.size();
    }

    @Override
    public String getRowText(int row) {
        return strList.get(row);
    }

    public void add(String str) {
        strList.add(str);
        updateColumn(str);
    }

    private void updateColumn(String str) {
        if (str.length() > columns) {
            columns = str.length();
        }
        for (int rows = 0; rows < strList.size(); rows++) {
            int fills = columns - strList.get(rows).length();
            if (fills > 0) {
                strList.set(rows, strList.get(rows) + fillSpace(fills));
            }
        }
    }

    private String fillSpace(int count) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < count; i++) {
            stringBuffer.append(' ');
        }
        return stringBuffer.toString();
    }

}
