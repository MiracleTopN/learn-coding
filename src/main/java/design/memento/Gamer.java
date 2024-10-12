package design.memento;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Originator(生成者角色) 负责生成Memento或者保存到Memento
 * @author hason
 * @since 2023/6/29 23:33
 */
public class Gamer {

    private int money;

    private List<String> fruits = new ArrayList<>();

    private Random random = new Random();

    private static String[] fruitname = {"苹果", "葡萄", "香蕉", "橘子"};

    public Gamer(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void bet() {
        int dice = random.nextInt(6) + 1;
        if (dice == 1) {
            money += 100;
            System.out.println("所持金钱增加了");
        } else if (dice == 2) {
            money /= 2;
            System.out.println("所持金钱减半了");
        } else if (dice == 6) {
            String f = getFruits();
            fruits.add(f);
            System.out.println("获得了水果(" + f + ")。");
        } else {
            System.out.println("什么都没有发生");
        }
    }

    public Memento createMemento() {
        Memento m = new Memento(money);
        Iterator<String> it = fruits.listIterator();
        while (it.hasNext()) {
            String f = it.next();
            if (f.startsWith("delicious")) {
                m.addFruit(f);
            }
        }
        return m;
    }

    public void restoreMemento(Memento memento) {
        this.money = memento.getMoney();
        this.fruits = memento.getFruits();
    }

    @Override
    public String toString() {
        return "[money = " + money + ", fruits = " + fruits;
    }

    private String getFruits() {
        String prefix = "";
        if (random.nextBoolean()) {
            prefix = "delicious";
        }
        return prefix + fruitname[random.nextInt(fruitname.length)];
    }

}
