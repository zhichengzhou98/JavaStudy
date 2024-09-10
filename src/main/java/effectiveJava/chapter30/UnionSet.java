package effectiveJava.chapter30;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-09-10 17:16
 */
@Slf4j
public class UnionSet {
  Set<Integer> set1;
  Set<Double> set2;
  Set<Integer> set3;
  @BeforeEach
  void init() {
    set1 = new HashSet<>(Set.of(1, 2));
    set2 = new HashSet<>(Set.of(1.0, 2.0));
    set3 = new HashSet<>(Set.of(2, 4));
  }

  @Test
  void testUnion() {
    Set<Integer> union = union(set1, set3);
    log.info("union:{}", union);
  }

  @Test
  void testUnionV1() {
    var numbers = unionV1(set1, set2);
    log.info("union:{}", numbers);
    var clazz = numbers.getClass();
    log.info("union Class Name:{}", clazz.getName());
    Type genericSuperclass = clazz.getGenericSuperclass();
    if (genericSuperclass instanceof ParameterizedType) {
      ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
      Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
      for (Type type : actualTypeArguments) {
        log.info("union 泛型类型:{}", type.getTypeName());
      }
    }

  }
  private <E> Set<E> union(Set<E> set1, Set<E> set2) {
    set1.addAll(set2);
    return set1;
  }

  private <E> Set<E> unionV1(Set<? extends E> set1, Set<? extends E> set2) {
    Set<E> res = new HashSet<>();
    res.addAll(set1);
    res.addAll(set2);
    return res;
  }
}
