package design_pattern.singleton.synclazy;

/**
 * @author zzc
 * @Description
 * @create 2023-04-09 16:31
 */
public class Sun {

    private static Sun sun;

    private Sun() {

    }

    public synchronized static Sun getInstance() {
        if (sun == null) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sun = new Sun();
        }
        return sun;
    }
}
