package effectiveJava.staticFactory;

import java.util.EnumSet;
import java.util.List;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-06-20 15:48
 */
public class EnumSet0620 {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3);
        EnumSet<Season> enumSet = EnumSet.of(Season.SPRING, Season.AUTUMN);
        System.out.println(enumSet);
    }
}

enum Season {
    SPRING,
    SUMMER,
    AUTUMN,
    WINTER;
}
