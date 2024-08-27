package design_pattern.factory_method.abstractfactory;

/**
 * @author zzc
 * @Description
 * @create 2023-04-10 20:56
 */
public class Mouse extends LowUnit{
    public Mouse(int x, int y) {
        super(x, y);
    }

    @Override
    public void show() {
        System.out.println("老鼠x坐标:" + x);
        System.out.println("老鼠y坐标:" + y);
    }

    @Override
    public void attack() {
        System.out.println("老鼠攻击力:" + attack);
    }
}
