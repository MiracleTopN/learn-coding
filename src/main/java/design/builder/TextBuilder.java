package design.builder;

/**
 * @author hason
 * @since 2023/6/6 00:38
 */
public class TextBuilder extends AbstractBuilder {

    private StringBuffer buffer = new StringBuffer();

    @Override
    public void buildTitle(String title) {
        buffer.append("================================\n");
        buffer.append("[" + title + "]\n");
        buffer.append("\n");
    }

    @Override
    public void buildString(String str) {
        buffer.append("🟥" + str + "\n");
        buffer.append("\n");
    }

    @Override
    public void buildItems(String[] items) {
        for (int i = 0; i < items.length; i++) {
            buffer.append("  ·" + items[i] + "\n");
        }
        buffer.append("\n");
    }

    @Override
    public void doClose() {
        buffer.append("================================\n");
    }

    public String getResult() {
        return buffer.toString();
    }
}
