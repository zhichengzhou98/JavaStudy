package design_pattern.factory_method.sample;

import design_pattern.factory_method.game.Enemy;

/**
 * @author zzc
 * @Description
 * @create 2023-04-10 15:23
 */
public interface Factory {
    Enemy create(int screenWidth);
}
