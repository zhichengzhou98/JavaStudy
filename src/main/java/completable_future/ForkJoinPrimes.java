package completable_future;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinPrimes extends RecursiveTask<List<Long>> {

  private static final int THRESHOLD = 10_000; // 任务拆分阈值
  private long start;
  private long end;

  public ForkJoinPrimes(long start, long end) {
    this.start = start;
    this.end = end;
  }

  @Override
  protected List<Long> compute() {
    List<Long> primes = new ArrayList<>();

    // 如果范围小于阈值，直接计算质数
    if (end - start <= THRESHOLD) {
      for (long number = start; number <= end; number++) {
        if (isPrime(number)) {
          primes.add(number);
        }
      }
    } else {
      // 拆分任务
      long middle = (start + end) / 2;
      ForkJoinPrimes leftTask = new ForkJoinPrimes(start, middle);
      ForkJoinPrimes rightTask = new ForkJoinPrimes(middle + 1, end);

      // 异步执行子任务
      leftTask.fork();
      List<Long> rightResult = rightTask.compute(); // 直接计算右侧任务
      List<Long> leftResult = leftTask.join(); // 获取左侧任务结果

      // 合并结果
      primes.addAll(leftResult);
      primes.addAll(rightResult);
    }

    return primes;
  }

  // 判断一个数是否为质数
  private boolean isPrime(long number) {
    if (number < 2) return false;
    if (number == 2) return true;
    if (number % 2 == 0) return false;
    for (long i = 3; i * i <= number; i += 2) {
      if (number % i == 0) {
        return false;
      }
    }
    return true;
  }

  private List<Long> getAllPrimes() {
    List<Long> res = new ArrayList<>();
    for (long i = start; i <= end ; i++) {
      if (isPrime(i)) {
        res.add(i);
      }
    }
    return res;
  }

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();

    // 创建 ForkJoinPool
    ForkJoinPool pool = ForkJoinPool.commonPool();

    // 创建并提交任务
    ForkJoinPrimes task = new ForkJoinPrimes(2, (long) 1e8);
    List<Long> primes = pool.invoke(task);
    //List<Long> primes = task.getAllPrimes();

    long endTime = System.currentTimeMillis();

    // 输出结果
    System.out.println("1e9 以内的质数个数: " + primes.size());
    System.out.println("计算时间: " + (endTime - startTime) + " ms");
  }
}
