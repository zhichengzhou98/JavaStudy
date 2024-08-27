package design_pattern.factory_method.sample;

import java.util.Random;

import design_pattern.factory_method.game.Airplane;
import design_pattern.factory_method.game.Enemy;

/**
 * @author zzc
 * @Description
 * @create 2023-04-10 15:24
 */
public class AirplaneFactory implements Factory{

    @Override
    public Enemy create(int screenWidth) {
        Random random = new Random();
        return new Airplane(random.nextInt(screenWidth), 0);
    }
}
