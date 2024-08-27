package design_pattern.singleton.hungrystyle;

/**
 * @author zzc
 * @Description
 * @create 2023-04-09 16:15
 */


public class Sun {

    private String name;

    private static final Sun sun = new Sun();

    private Sun() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        name = "ty";
    }

    public static Sun getSun() {
        return sun;
    }

  /*  @Override
    public String toString() {
        return "Sun{" +
                "name='" + name + '\'' +
                '}';
    }*/
}
