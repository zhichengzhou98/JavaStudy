package design_pattern.factory_method.game;

/**
 * @author zzc
 * @Description
 * @create 2023-04-09 22:01
 */
public class Airplane extends Enemy {
    public Airplane(int x, int y) {
        super(x, y);
    }

    @Override
    public void show() {
        System.out.printf("飞机的坐标为x: %d, y: %d\n", x, y);
        System.out.println("飞机");
    }
}
