package design_pattern.singleton.lazy;


/**
 * @author zzc
 * @Description 线程不安全
 * @create 2023-04-09 16:35
 */
public class TestMethod implements Runnable {
    public static void main(String[] args) {


        Thread thread = new Thread(new TestMethod());
        Thread thread1 = new Thread(new TestMethod());
        Thread thread2 = new Thread(new TestMethod());
        Thread thread3 = new Thread(new TestMethod());

        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();


    }

    @Override
    public void run() {
        Sun sun = Sun.getInstance();
        System.out.println(sun);
    }
}