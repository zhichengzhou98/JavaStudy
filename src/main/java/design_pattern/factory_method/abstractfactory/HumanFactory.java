package design_pattern.factory_method.abstractfactory;

/**
 * @author zzc
 * @Description
 * @create 2023-04-10 20:46
 */
public class HumanFactory implements AbstractFactory {

    private int x;
    private int y;

    public HumanFactory(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public HighUnit createHighUnit() {
        System.out.println("创建坦克");
        return new Tank(x, y);
    }

    @Override
    public LowUnit createLowUnit() {
        System.out.println("创建士兵");
        return new Marine(x, y);
    }
}
