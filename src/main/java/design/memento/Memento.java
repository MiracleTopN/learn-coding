package design.memento;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Memento(纪念品角色) 负责保存具体信息
 * 宽窄接口的使用 有效的保障了对象的封装性
 * @author hason
 * @since 2023/6/29 23:22
 */
public class Memento implements Serializable {

    private int money;

    private int number;

    private List<String> fruit;

    // 窄接口 narrow interface: 窄接口可以操作对象信息较少 相应的他的访问范围较大(public)
    public int getMoney() {
        return this.money;
    }

    int getNumber() {
        return this.number;
    }

    // 注意以下方法的访问修饰符 都是包访问权限
    // 宽接口 wide interface: 通过宽接口可以操作的对象信息较多，相应的他的访问范围较小（包访问）
    Memento(int money) {
        this.money = money;
        this.fruit = new ArrayList<>();
    }

    // wide interface 宽接口
    void addFruit(String fruit) {
        this.fruit.add(fruit);
    }

    // wide interface 宽接口
    List<String> getFruits() {
        return this.fruit;
    }

}
