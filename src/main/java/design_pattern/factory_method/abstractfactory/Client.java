package design_pattern.factory_method.abstractfactory;

/**
 * @author zzc
 * @Description
 * @create 2023-04-10 21:07
 */
public class Client {
    public static void main(String[] args) {
        AbstractFactory factory = new HumanFactory(10, 10);
        for (int i = 0; i < 5; i++) {
            HighUnit highUnit = factory.createHighUnit();
            highUnit.show();
            highUnit.attack();
        }

        System.out.println("==========================");
        factory = new AnimalFactory(20, 30);
        for (int i = 0; i < 5; i++) {
            LowUnit lowUnit = factory.createLowUnit();
            lowUnit.attack();
            lowUnit.show();
        }


    }
}
