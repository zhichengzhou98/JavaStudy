package design_pattern.prototype.game;

/**
 * @author zzc
 * @Description
 * @create 2023-04-09 21:35
 */
public class Bullet implements Cloneable{
    public Bullet() {
    }

    @Override
    protected Bullet clone() throws CloneNotSupportedException {
        return (Bullet) super.clone();
    }
}
