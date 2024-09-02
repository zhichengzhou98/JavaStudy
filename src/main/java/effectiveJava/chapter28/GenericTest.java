package effectiveJava.chapter28;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-09-02 17:50
 */
public class GenericTest {
  @Test
  void testFun() {
    //List<String>[] arr = new List<String>[6]; 非法
    List<?>[] result = new List<?>[6]; //合法
    for (int i = 0; i < result.length; i++) {
      result[i] = new ArrayList<Integer>();
      //result[i].add();
    }


    List<String>[] arr = new List[6];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = new ArrayList<>();
    }
  }
}
