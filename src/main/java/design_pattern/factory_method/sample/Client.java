package design_pattern.factory_method.sample;

import java.util.Random;

/**
 * @author zzc
 * @Description
 * @create 2023-04-09 22:07
 */
public class Client {
    public static void main(String[] args) {
        int screenWidth = 100;
        Random random = new Random();
        System.out.println("游戏开始");

        /*int x = random.nextInt(screenWidth);
        Airplane airplane = new Airplane(x, 0);
        airplane.show();
        x = random.nextInt(screenWidth);
        Tank tank = new Tank(x, 0);
        tank.show();*/
        /*SimpleFactory simpleFactory = new SimpleFactory(screenWidth);
        Enemy airplane = simpleFactory.createEnemy("Airplane");
        airplane.show();
        Enemy tank = simpleFactory.createEnemy("Tank");
        tank.show();*/
        Factory factory = new TankFactory();
        for (int i = 0; i < 5; i++) {
            factory.create(screenWidth).show();
        }
        factory = new AirplaneFactory();
        for (int i = 0; i < 5; i++) {
            factory.create(screenWidth).show();

        }
    }
}
