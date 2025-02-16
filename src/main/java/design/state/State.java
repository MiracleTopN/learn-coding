package design.state;

/**
 * State角色(状态)
 * @author hason
 * @since 2023/7/2 19:26
 */
public interface State {
    /**
     * 设置时间
     * @param context
     * @param hour
     */
    void doClock(Context context, int hour);

    /**
     * 使用金库
     * @param context
     */
    void doUse(Context context);

    /**
     * 按下警铃
     * @param context
     */
    void doAlarm(Context context);

    /**
     * 正常通话
     * @param context
     */
    void doPhone(Context context);
}
