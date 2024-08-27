package design_pattern.factory_method.abstractfactory;

/**
 * @author zzc
 * @Description
 * @create 2023-04-10 20:45
 */
public interface AbstractFactory {
    HighUnit createHighUnit();
    LowUnit createLowUnit();
}
