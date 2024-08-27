package design_pattern.singleton.hungrystyle;

/**
 * @author zzc
 * @Description
 * @create 2023-04-09 16:16
 */
public class TestMethod implements Runnable{
    public static void main(String[] args) {
        Sun sun = Sun.getSun();
        System.out.println(sun);
        Sun sun2 = Sun.getSun();
        System.out.println(sun == sun2);

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
        Sun sun = Sun.getSun();
        System.out.println(sun);
    }
}
