package streamtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-09-02 16:47
 */
public class ModifyList {
  public static void main(String[] args) {
    int[] arr = new int[]{1,3,5};
    List<Integer> list = new ArrayList<>(generateUnmodifiedList(arr));
    list.add(100);
    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }
  }

  /**
   * 将arr转成不可变List
   * @param arr
   * @return
   */
  private static List<Integer> generateUnmodifiedList(int[] arr) {
    return Arrays.stream(arr).boxed().toList();
  }


  /**
   * 将arr转成可变list
   * @param arr
   * @return
   */
  private static List<Integer> generateModifiedList(int[] arr) {
    return new ArrayList<>(Arrays.stream(arr).boxed().toList());
  }
}
