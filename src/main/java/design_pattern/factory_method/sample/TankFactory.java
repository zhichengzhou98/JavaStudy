package design_pattern.factory_method.sample;

import java.util.Random;

import design_pattern.factory_method.game.Tank;
import design_pattern.factory_method.game.Enemy;

/**
 * @author zzc
 * @Description
 * @create 2023-04-10 15:27
 */
public class TankFactory implements Factory {
  @Override
  public Enemy create(int screenWidth) {
    Random random = new Random();
    return new Tank(random.nextInt(screenWidth), 0);
  }
}
