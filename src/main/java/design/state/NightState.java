package design.state;

/**
 * ConcreteState角色
 * @author hason
 * @since 2023/7/2 19:29
 */
public class NightState implements State {

    private static NightState nightState = new NightState();

    public static NightState getInstance() {
        return nightState;
    }

    @Override
    public void doClock(Context context, int hour) {
        if (hour >= 8 && hour < 21) {
            context.changeState(DayState.getInstance());
        } else if (hour >= 12 && hour < 13) {
            context.changeState(NoonState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {
        context.callSecurityCenter("紧急~晚上使用金库！");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("按下警铃(晚上)");
        context.changeState(UrgentState.getInstance());
    }

    @Override
    public void doPhone(Context context) {
        context.recordLog("晚上的通话录音");
    }

    @Override
    public String toString() {
        return "[晚上]";
    }

}
