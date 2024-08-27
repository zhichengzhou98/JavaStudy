package design_pattern.factory_method.abstractfactory;

/**
 * @author zzc
 * @Description
 * @create 2023-04-10 20:59
 */
public class Cat extends HighUnit{
    public Cat(int x, int y) {
        super(x, y);
    }

    @Override
    public void show() {
        System.out.println("猫x坐标:" + x);
        System.out.println("猫y坐标:" + y);
    }

    @Override
    public void attack() {
        System.out.println("猫攻击力:" + attack);
    }
}
