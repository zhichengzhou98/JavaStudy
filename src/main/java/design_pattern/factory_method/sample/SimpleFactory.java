package design_pattern.factory_method.sample;

import java.util.Random;

import design_pattern.factory_method.game.Tank;
import design_pattern.factory_method.game.Airplane;
import design_pattern.factory_method.game.Enemy;

/**
 * @author zzc
 * @Description
 * @create 2023-04-10 14:31
 */
public class SimpleFactory {
    private int screenWidth;
    private Random random;

    public SimpleFactory(int screenWidth) {
        this.screenWidth = screenWidth;
        this.random = new Random();
    }

    public Enemy createEnemy(String type) {
        int x = random.nextInt(screenWidth);
        Enemy enemy = null;
        switch (type) {
            case "Airplane":
                enemy = new Airplane(x, 0);
                break;
            case "Tank":
                enemy = new Tank(x, 0);
                break;
        }
        return enemy;
    }
}
