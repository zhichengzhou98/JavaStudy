package streamtest.mapremove;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-09-03 14:18
 */
@Slf4j
public class RemoveMapKey {

  private static Map<String, Integer> map = new HashMap<>();

  static {
    map.put("zzc", 1);
    map.put("zzc1", 2);
    map.put("zzc2", 3);
    map.put("zzc3", 4);
  }


  public static void main(String[] args) {
    Set<String> removedSet = Set.of("zzc", "zzc1", "zzc345");
    for (String key : removedSet) {
      map.remove(key);
    }
    log.info("map={}", map);
  }

  @Test
  void testFun() {
    Set<String> removedSet = Set.of("zzc", "zzc1", "zzc345");
    Assert.assertThrows(ConcurrentModificationException.class, () -> extracted(map, removedSet));
  }

  private void extracted(Map<String, Integer> map, Set<String> removedSet) {
    for (String key : map.keySet()) {
      if (removedSet.contains(key)) {
        map.remove(key);
      }
    }
  }
}
