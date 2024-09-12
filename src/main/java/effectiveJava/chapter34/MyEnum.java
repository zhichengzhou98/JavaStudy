package effectiveJava.chapter34;

import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import lombok.extern.slf4j.Slf4j;

import static java.util.stream.Collectors.toMap;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-09-12 17:35
 */
@Slf4j
public class MyEnum {
  @Test
  void testFun() {
    Apple[] values = Apple.values();
    for(Apple a: values) {
      log.info("a: {}", a);
    }
    log.info("apple: {}", Apple.FUJI.compareTo(Apple.GRANNY_SMITH));
    log.info("apple: {}", Apple.valueOf("FUJI"));
  }

  @Test
  void testFromString() {
    Apple my = Apple.fromString("GRANNY_SMITH123").orElse(Apple.FUJI);
    log.info("{}", my);

  }

  private enum Apple {
    FUJI,
    PIPPIN,
    GRANNY_SMITH;
    // Implementing a fromString method on an enum type
    private static final Map<String, Apple> stringToEnum =
        Stream.of(values()).collect(
            toMap(Object::toString, e -> e));

    // Returns Operation for string, if any
    public static Optional<Apple> fromString(String symbol) {
      return Optional.ofNullable(stringToEnum.get(symbol));
    }
  }
  private enum Orange {NAVEL, TEMPLE, BLOOD}
}
// Abuse of ordinal to derive an associated value - DON'T DO THIS
enum Ensemble {
  SOLO,   DUET,   TRIO, QUARTET, QUINTET,
  SEXTET, SEPTET, OCTET, NONET,  DECTET;

  public int numberOfMusicians() { return ordinal() + 1; }
}


