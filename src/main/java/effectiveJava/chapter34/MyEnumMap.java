package effectiveJava.chapter34;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-09-18 10:39
 */
@Slf4j
public class MyEnumMap {
  enum Season {
    SPRING,
    SUMMER,
    AUTUMN,
    WINTER;
  }

  @Test
  void testFun() {
    //Map<Season, Set<Integer>> seasonSetMap = new HashMap<>();
    EnumMap<Season, Set<Integer>> seasonSetMap = new EnumMap<>(Season.class);
    Set<Integer> setSpring = Set.of(1, 2, 3);
    Set<Integer> setSummer = Set.of(4, 5, 6);
    seasonSetMap.put(Season.SPRING, setSpring);
    seasonSetMap.put(Season.SUMMER, setSummer);
    log.info("map:{}", seasonSetMap);

    Season[] enumConstants = Season.class.getEnumConstants();
    log.info("string[]:{}", Arrays.toString(enumConstants));
  }
}
