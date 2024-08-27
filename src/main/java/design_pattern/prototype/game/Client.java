package design_pattern.prototype.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author zzc
 * @Description
 * @create 2023-04-09 17:58
 */
public class Client {
    public static void main(String[] args) {
        List<EnemyPlane> enemyPlanes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            //每次都用new创建对象 消耗性能
            EnemyPlane enemyPlane = EnemyPlaneFactory.getInstance(new Random().nextInt(200));
            //EnemyPlane enemyPlane = new EnemyPlane(new Random().nextInt(200));
            enemyPlanes.add(enemyPlane);
        }
        enemyPlanes.forEach(System.out::println);
    }
}
