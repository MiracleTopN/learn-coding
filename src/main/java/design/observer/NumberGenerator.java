package design.observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Subject 被观察者
 * @author hason
 * @since 2023/6/28 20:05
 */
public abstract class NumberGenerator {

    // 用接口来保存实例 提高了可复用性
    private List<Observer> observerList = new ArrayList<>();

    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    public void deleteObserver(Observer observer) {
        observerList.remove(observer);
    }

    // 通知所有的观察者
    // 在通知时，要注意observer反过来suject进行修改可能引发的无限循环
    public void notifyObservers() {
        Iterator<Observer> it = observerList.listIterator();
        while (it.hasNext()) {
            Observer o = it.next();
            // 如果传递信息过多(eg.update(Subject subject,int i)),可能会导致subject对observer的了解过多 耦合性增强
            // 如果传递的消息过少(eg. update(int i )) 可能会导致多个observer观察对象时不知道究竟观察的是哪个subject
            o.update(this);
        }
    }

    public abstract int getNumber();

    public abstract void execute();

}
