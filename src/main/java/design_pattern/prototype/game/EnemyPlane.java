package design_pattern.prototype.game;

/**
 * @author zzc
 * @Description
 * @create 2023-04-09 17:57
 */
public class EnemyPlane implements Cloneable {
    private int x; //敌机横坐标
    private int y; //敌机纵坐标
    private Bullet bullet;

    //private Bullet bullet = new Bullet();
    public EnemyPlane(int x, Bullet bullet) {
        this.bullet = bullet;
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Bullet getBullet() {
        return bullet;
    }

    public void setBullet(Bullet bullet) {
        this.bullet = bullet;
    }

    public void fly() {
        y++;
    }

    //让克隆后的敌机修改横坐标
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public EnemyPlane clone() throws CloneNotSupportedException {
        EnemyPlane clone = (EnemyPlane) super.clone();
        clone.setBullet(this.bullet.clone());
        return clone;
    }
}
