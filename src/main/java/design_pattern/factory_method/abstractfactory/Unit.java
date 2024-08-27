package design_pattern.factory_method.abstractfactory;

/**
 * @author zzc
 * @Description
 * @create 2023-04-10 17:42
 */
public abstract class Unit {
    protected int attack;

    protected  int x;
    protected  int y;

    public Unit(int attack, int x, int y) {
        this.attack = attack;
        this.x = x;
        this.y = y;
    }

    public abstract void show();

    public abstract void  attack();
}
