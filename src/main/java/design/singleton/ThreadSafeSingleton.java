package design.singleton;

/**
 * @author hason
 * @since 2023/6/4 23:19
 */
public class ThreadSafeSingleton {

    private static ThreadSafeSingleton singleton = null;

    private ThreadSafeSingleton() {

    }

    /**
     * 类锁
     * @return
     */
    public static synchronized ThreadSafeSingleton getInstance() {
        if (singleton == null) {
            singleton = new ThreadSafeSingleton();
        }
        return singleton;
    }
}
