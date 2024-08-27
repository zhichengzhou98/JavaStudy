package design_pattern.factory_method.game;

/**
 * @author zzc
 * @Description
 * @create 2023-04-09 21:58
 */
public abstract class Enemy {
    protected int x;
    protected int y;

    public Enemy() {
    }

    public Enemy(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract void show();
}
