package effectiveJava.chapter40;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-10-15 16:59
 */
@Slf4j
public class LambdaTest {
  public static void main(String[] args) {
    List<String> strs = new ArrayList<>(List.of("zzc", "zs23", "asfa", "z"));
    //strs不加泛型则编译失败
    //strs.sort((a, b) -> b.length() - a.length());
    strs.sort(Comparator.comparingInt(x -> -x.length()));
    log.info("strs:{}", strs);
  }
}
