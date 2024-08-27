package design_pattern.factory_method.abstractfactory;

/**
 * @author zzc
 * @Description
 * @create 2023-04-10 20:50
 */
public class Marine extends LowUnit {

    public Marine(int x, int y) {
        super(x, y);
    }

    @Override
    public void show() {
        System.out.println("士兵x坐标:" + x);
        System.out.println("士兵y坐标:" + y);
    }

    @Override
    public void attack() {
        System.out.println("士兵攻击力" + attack);
    }
}
