package effectiveJava.chapter30;

import java.util.function.UnaryOperator;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-09-10 16:23
 */
@Slf4j
public class GenericFun {
  private static final UnaryOperator<Object> IDENTITY_FN = t -> t;


  @SuppressWarnings("unchecked")
  private static <T> UnaryOperator<T> identityFun() {
    return (UnaryOperator<T>) IDENTITY_FN;
  }

  public static void main(String[] args) {
    String[] strs = {"1", "2", "3"};
    UnaryOperator<String> strOperator = identityFun();
    UnaryOperator<Integer> intOperator = identityFun();
    for (String str : strs) {
      log.info(strOperator.apply(str));
    }
    int[] arr = {1, 2, 3};
    for (int num : arr) {
      log.info("{}", intOperator.apply(num));
    }

  }

}
