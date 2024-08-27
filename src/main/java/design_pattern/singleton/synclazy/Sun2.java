package design_pattern.singleton.synclazy;

/**
 * @author zzc
 * @Description
 * @create 2023-04-09 16:31
 */
public class Sun2 {

    private volatile static Sun2 sun; // 是否必须加 volatile关键字

    private Sun2() {

    }

    public static Sun2 getInstance() {
        if (sun == null) {

            synchronized (Sun.class) {

                if (sun == null) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    sun = new Sun2();
                }
            }

        }
        return sun;
    }
}
