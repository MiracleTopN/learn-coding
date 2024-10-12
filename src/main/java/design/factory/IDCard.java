package design.factory;

/**
 * @author hason
 * @since 2023/6/4 18:00
 */
public class IDCard extends Product {

    private String owner;

    private int serialNo;

    IDCard(String owner, int serialNo) {
        System.out.println("制作" + owner + "(" + serialNo + ")" + "的ID卡。");
        this.owner = owner;
        this.serialNo = serialNo;
    }

    @Override
    public void use() {
        System.out.println("使用" + owner + "(" + serialNo + ")" + "的ID卡。");
    }

    public String getOwner() {
        return owner;
    }

    public int getSerialNo() {
        return serialNo;
    }
}
