package design.singleton;

/**
 * @author hason
 * @since 2023/6/4 23:22
 */
public class ThreadUnsafeSingleton {

    private static ThreadUnsafeSingleton singleton = null;

    private ThreadUnsafeSingleton() {
        System.out.println("生成了一个实例:" + Thread.currentThread().getName());
        slowdown();
    }

    /**
     * 无 synchronized 线程不安全
     * @return
     */
    public static ThreadUnsafeSingleton getInstance() {
        if (singleton == null) {
            singleton = new ThreadUnsafeSingleton();
        }
        return singleton;
    }

    private void slowdown() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class Main extends Thread {

        public Main(String name) {
            super(name);
        }

        @Override
        public void run() {
            ThreadUnsafeSingleton singleton = ThreadUnsafeSingleton.getInstance();
            System.out.println("threadUnsafeSingleton is " + singleton);
        }

        public static void main(String[] args) {
            new Main("A").start();
            new Main("B").start();
            new Main("C").start();
        }
    }

}
