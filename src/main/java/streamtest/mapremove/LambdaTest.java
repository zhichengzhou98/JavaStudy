package streamtest.mapremove;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-10-11 10:36
 */
@Slf4j
public class LambdaTest {
  public static void main(String[] args) {
    int num = 10;
    Person p1 = new Person("p1");
    Runnable r = () -> {
      //num++;
      log.info("test lambda {}", num);
      log.info("lambda before update: {}", p1);
      p1.name = "p2";
      log.info("lambda after update: {}", p1);
    };
    log.info("before run lambda: {}", p1);
    r.run();
    log.info("after run lambda: {}", p1);
  }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Person {
  String name;
}
