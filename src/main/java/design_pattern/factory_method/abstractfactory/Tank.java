package design_pattern.factory_method.abstractfactory;

/**
 * @author zzc
 * @Description
 * @create 2023-04-10 20:54
 */
public class Tank extends HighUnit{

    public Tank(int x, int y) {
        super(x, y);
    }

    @Override
    public void show() {
        System.out.println("坦克x坐标:" + x);
        System.out.println("坦克y坐标:" + y);
    }

    @Override
    public void attack() {
        System.out.println("坦克攻击力：" + attack);
    }
}
