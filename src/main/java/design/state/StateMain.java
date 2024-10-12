package design.state;

/**
 * State模式(分而治之)
 * 优点: 
 *     1.可以很容易从代码上了解到state的变化(只需要看DayState或者NightState的代码就可以了)
 *     2.让每个类代表一个状态，结构更清晰；避免代码中因为修改变量(用变量代表状态时)而产生的状态转移之间的互相矛盾
 *     3.用接口表示状态，可以很好的控制每个状态的行为(不易遗漏)
 * 缺点: 每个ConcreteState都必须知道其他ConcreteState的存在 耦合度增强 代码不好修改
 * 另外 可以用状态迁移表代替State模式
 * @author hason
 * @since 2023/7/2 20:00
 */
public class StateMain {

    public static void main(String[] args) {
        SafeFrame frame = new SafeFrame("State Sample");
        while (true) {
            for (int hour = 0; hour < 24; hour++) {
                frame.setClock(hour);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
