package concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author hason
 * @since 2023/6/19 15:31
 */
public class CompletationTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        AtomicReference<Boolean> res = new AtomicReference<>(true);

        List<CompletableFuture<Boolean>> list = new ArrayList<>();
        // 创建一个异步操作
        CompletableFuture<Boolean> future = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("future do something");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            res.set(true);
            return true;
        });
        CompletableFuture<Boolean> future2 = future.whenCompleteAsync((result, exception) -> {
            if (exception != null) {
                System.out.println("There was an error: " + exception.getMessage());
            } else {
                try {
                    Thread.sleep(1000);
                    throw new InterruptedException("error");
                } catch (InterruptedException e) {
                    res.set(false);
                    e.printStackTrace();
                }
            }
        }, Executors.newSingleThreadExecutor());
        list.add(future);
        CompletableFuture.allOf(list.toArray(new CompletableFuture[0]))
                .get(3000, TimeUnit.MILLISECONDS);
        System.out.println("res is " + res);
    }

}
