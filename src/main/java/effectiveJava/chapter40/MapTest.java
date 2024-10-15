package effectiveJava.chapter40;

import java.util.HashMap;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-10-15 17:18
 */
@Slf4j
public class MapTest {
  public static void main(String[] args) {
    HashMap<String, Integer> map = new HashMap<>();
    map.put("key", 5);
    map.merge("key", 3, Integer::sum);
    log.info("map: {}", map);
  }
}
