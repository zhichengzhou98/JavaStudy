package completable_future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-10-14 16:29
 */
@Slf4j
public class AsyncResult {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    long begin = System.currentTimeMillis();
    AsyncResult ar = new AsyncResult();
    //ar.sequentialExecution();
    ar.parallelExecution();
    //ar.parallelExecutionMutiGet();
    long end = System.currentTimeMillis();
    log.info("耗时：{}s", (end - begin) / 1000.0);
  }

  private void parallelExecutionMutiGet() throws ExecutionException, InterruptedException {
    List<Integer> res = new ArrayList<>();
    //分别执行get
    CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(this::method1);
    CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(this::method2);
    CompletableFuture<Integer> f3 = CompletableFuture.supplyAsync(this::method3);
    res.add(f1.get());
    res.add(f2.get());
    res.add(f3.get());
    log.info("返回结果为：{}", res);
  }

  //CompletableFuture并行执行
  private void parallelExecution() {
    //创建时任务就立即执行 并不是等调用.get()方法才执行任务；
    //.get()主要是阻塞主线程 获取任务的返回结果
    CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(this::method1);
    CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(this::method2);
    CompletableFuture<Integer> f3 = CompletableFuture.supplyAsync(this::method3);
    CompletableFuture<Void> result = CompletableFuture.allOf(f1, f2, f3);
    CompletableFuture<List<Integer>> allResult =
        result
            .thenApply(
                v -> Stream.of(f1, f2, f3)
                    .map(CompletableFuture::join)
                    .toList()
            );
    List<Integer> list = null;
    try {
      list = allResult.get();
    } catch (Exception e) {
      log.error("error", e);
    }
    log.info("返回结果为：{}", list);
  }

  //顺序执行
  private void sequentialExecution() {
    method1();
    method2();
    method3();
  }

  private int method1() {
    try {
      Thread.sleep(2000);
      return 1;
    } catch (InterruptedException e) {
      return 0;
    }
  }

  private int method2() {
    try {
      Thread.sleep(4000);
      return 2;
    } catch (InterruptedException e) {
      return 0;
    }
  }

  private int method3() {
    try {
      Thread.sleep(6000);
      return 3;
    } catch (InterruptedException e) {
      return 0;
    }
  }
}
