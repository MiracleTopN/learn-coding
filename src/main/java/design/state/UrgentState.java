package design.state;

/**
 * @author hason
 * @since 2023/7/3 17:08
 */
public class UrgentState implements State {

    private static UrgentState urgentState = new UrgentState();

    public static UrgentState getInstance() {
        return urgentState;
    }

    @Override
    public void doClock(Context context, int hour) {

    }

    @Override
    public void doUse(Context context) {
        context.callSecurityCenter("紧急~紧急时使用金库");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("按下警铃(紧急时)");
    }

    @Override
    public void doPhone(Context context) {
        context.callSecurityCenter("正常通话(紧急时)");
    }

    @Override
    public String toString() {
        return "[紧急时]";
    }

}
