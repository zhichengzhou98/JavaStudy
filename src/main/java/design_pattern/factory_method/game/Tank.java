package design_pattern.factory_method.game;

/**
 * @author zzc
 * @Description
 * @create 2023-04-09 22:05
 */
public class Tank extends Enemy {
    public Tank() {
    }

    public Tank(int x, int y) {
        super(x, y);
    }

    @Override
    public void show() {
        System.out.printf("坦克的坐标为x: %d, y: %d\n", x, y);
        System.out.println("坦克");
    }
}
