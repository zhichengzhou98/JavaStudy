package design_pattern.factory_method.abstractfactory;

/**
 * @author zzc
 * @Description
 * @create 2023-04-10 20:58
 */
public class AnimalFactory implements AbstractFactory{
    private int x;
    private int y;

    public AnimalFactory(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public HighUnit createHighUnit() {
        return new Cat(x, y);
    }

    @Override
    public LowUnit createLowUnit() {
        return new Mouse(x, y);
    }
}
