package design.state;

/**
 * @author hason
 * @since 2023/7/3 16:41
 */
public class NoonState implements State {

    private static NoonState noonState = new NoonState();

    public static NoonState getInstance() {
        return noonState;
    }

    @Override
    public void doClock(Context context, int hour) {
        if (hour < 8 || hour >= 21) {
            context.changeState(NightState.getInstance());
        } else if (hour >= 8 && hour < 12 || hour >= 13 && hour < 21) {
            context.changeState(DayState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {
        context.callSecurityCenter("紧急~午间使用金库!");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("按下警铃(午间)");
        context.changeState(UrgentState.getInstance());
    }

    @Override
    public void doPhone(Context context) {
        context.recordLog("午餐时间的通话录音");
    }

    @Override
    public String toString() {
        return "[午餐时间]";
    }
}
