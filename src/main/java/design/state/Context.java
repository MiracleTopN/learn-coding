package design.state;

/**
 * Context角色（的一部分）: 提供了外部使用者使用state的api接口
 * @author hason
 * @since 2023/7/2 19:27
 */
public interface Context {

    /**
     * 设置时间
     * @param hour
     */
    void setClock(int hour);

    /**
     * 改变状态
     * @param state
     */
    void changeState(State state);

    /**
     * 联系警报中心
     * @param msg
     */
    void callSecurityCenter(String msg);

    /**
     * 在警报中心留下记录
     * @param msg
     */
    void recordLog(String msg);

}
