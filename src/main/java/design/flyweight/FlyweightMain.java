package design.flyweight;

/**
 * Flyweight模式:尽量通过共享实例来避免new出实例 从而减少内存的大小以及生成对象的时间消耗
 * 共享,就会存在一个地方修改 多个地方受到影响的情况（并不是所有的这种情况都是不好的）—— 所以要根据目的，对共享的对象精挑细选
 * Intrinsic(本质的/固有的):被共享的信息,不依赖位置和状况 比如BigChar类
 * Extrinsic(外在的/非本质的):不被共享的信息,依赖位置和状况 比如BigString类中BigChar是第几个字符
 * @author hason
 * @since 2023/7/5 00:54
 */
public class FlyweightMain {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java main digits");
            System.out.println("Example: java main 13561");
            System.exit(0);
        }
        // 共享
        BigString bs = new BigString(args[0], true);
        Runtime.getRuntime().gc();
        long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("使用内存 = " + used);
        bs.print();
        // 非共享 可以看出非共享使用的内存更大
//        BigString bs = new BigString(args[0], false);
//        Runtime.getRuntime().gc();
//        long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
//        System.out.println("使用内存 = " + used);
//        bs.print();
    }

}
