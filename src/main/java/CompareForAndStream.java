import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

/**
 * @author hason
 * @since 2024/1/5 11:08
 */
public class CompareForAndStream {

    public static void main(String[] args) {
        int size = 10000000; // 数据集大小
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }

        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            linkedList.add(i);
        }

//        // 测试 foreach arrayList
        long memoryBefore = getMemoryUsage();
        long startTime = System.nanoTime();
        foreachTest(list, x -> x * x);
        long endTime = System.nanoTime();
        long memoryAfter = getMemoryUsage();
        System.out.println("Foreach arrayList duration: " + (endTime - startTime) + " ns");
        System.out.println("Foreach arrayList memory usage: " + (memoryAfter - memoryBefore) / 1024 / 1024);
//
//        // 测试 foreach linkedList
//        memoryBefore = getMemoryUsage();
//        startTime = System.nanoTime();
//        foreachTest(linkedList, x -> x * x);
//        endTime = System.nanoTime();
//        memoryAfter = getMemoryUsage();
//        System.out.println("Foreach linked list duration: " + (endTime - startTime) + " ns");
//        System.out.println("Foreach linked list  memory usage: " + (memoryAfter - memoryBefore) / 1024 / 1024);
//
        // 测试 stream().map()
        memoryBefore = getMemoryUsage();
        startTime = System.nanoTime();
        streamMapTest(list, x -> x * x);
        endTime = System.nanoTime();
        memoryAfter = getMemoryUsage();
        System.out.println("Stream.map() duration: " + (endTime - startTime) + " ns");
        System.out.println("Stream.map() memory usage: " + (memoryAfter - memoryBefore) / 1024 / 1024);
//
        // 测试 forTest arrayList
        memoryBefore = getMemoryUsage();
        startTime = System.nanoTime();
        forTest(list, x -> x * x);
        endTime = System.nanoTime();
        memoryAfter = getMemoryUsage();
        System.out.println("forTest duration: " + (endTime - startTime) + " ns");
        System.out.println("forTest memory usage: " + (memoryAfter - memoryBefore) / 1024 / 1024);

//        // 测试 forTest linkedList
//        memoryBefore = getMemoryUsage();
//        startTime = System.nanoTime();
//        LinkedTest(linkedList);
//        endTime = System.nanoTime();
//        memoryAfter = getMemoryUsage();
//        System.out.println("forTest linkedList duration: " + (endTime - startTime) + " ns");
//        System.out.println("forTest linkedList memory usage: " + (memoryAfter - memoryBefore) / 1024 / 1024);
    }

    private static void foreachTest(List<Integer> list, Function<Integer, Integer> function) {
        for (Integer item : list) {
            function.apply(item);
        }
    }

    private static void streamMapTest(List<Integer> list, Function<Integer, Integer> function) {
        list.stream().map(function).forEach(x -> {
        });
    }

    private static void forTest(List<Integer> list, Function<Integer, Integer> function) {
        for (int i = 0; i < list.size(); i++) {
            function.apply(list.get(i));
        }
    }

    private static void LinkedTest(List<Integer> list) {
        for (Integer x : list) {
            x *= x;
        }
    }

    private static long getMemoryUsage() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }

}
