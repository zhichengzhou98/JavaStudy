package design_pattern.prototype.game;

/**
 * @author zzc
 * @Description
 * @create 2023-04-09 21:25
 */
public class EnemyPlaneFactory {

    private static final EnemyPlane protoType = new EnemyPlane(200, new Bullet());



    public static EnemyPlane getInstance(int x){
        System.out.println("protoType 子弹" + protoType.getBullet());
        EnemyPlane clone = null;
        try {
            clone = protoType.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        clone.setX(x);

        System.out.println("clone对象 子弹" + clone.getBullet());
        return clone;
    }

}
