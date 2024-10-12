package design.state;

/**
 * Concrete角色
 * @author hason
 * @since 2023/7/2 19:29
 */
public class DayState implements State {

    private static DayState singleton = new DayState();

    public static State getInstance() {
        return singleton;
    }

    @Override
    public void doClock(Context context, int hour) {
        if (hour < 8 || hour >= 21) {
            context.changeState(NightState.getInstance());
        } else if (hour >= 12 && hour < 13) {
            context.changeState(NoonState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {
        context.recordLog("使用金库(白天");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("按下警铃(白天)");
        context.changeState(UrgentState.getInstance());
    }

    @Override
    public void doPhone(Context context) {
        context.callSecurityCenter("正常通话(白天)");
    }

    @Override
    public String toString() {
        return "[白天]";
    }

}
