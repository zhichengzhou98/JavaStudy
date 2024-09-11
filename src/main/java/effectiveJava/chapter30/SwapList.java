package effectiveJava.chapter30;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-09-11 17:18
 */
@Slf4j
public class SwapList {

  List<Integer> intList;
  List<String> strList;
  @BeforeEach
  void init() {
    intList = new ArrayList<>(List.of(1, 2, 3));
    strList = new ArrayList<>(List.of("11", "22", "33"));
  }
  @Test
  void testFun() {
    log.info("intList: {}", intList);
    swap(intList, 0, 2);
    log.info("intList: {}", intList);

    log.info("strList: {}", strList);
    swap(strList, 0, 2);
    log.info("strList: {}", strList);
  }

  @Test
  void testFunV1() {
    log.info("intList: {}", intList);
    swapHelp(intList, 0, 2);
    log.info("intList: {}", intList);

    log.info("strList: {}", strList);
    swapHelp(strList, 0, 2);
    log.info("strList: {}", strList);
  }

  public void swap(List<?> list, int i, int j) {
    swapHelp(list, i, j);
  }

  private <E> void swapHelp(List<E> list, int i, int j) {
    list.set(i, list.set(j, list.get(i)));
  }

  @Test
  void testDangerous() {
    dangerous(List.of("1"));
  }

  // Mixing generics and varargs can violate type safety!
  static void dangerous(List<String>... stringLists) {
    List<Integer> intList = List.of(42);
    Object[] objects = stringLists;
    objects[0] = intList;             // Heap pollution
    String s = stringLists[0].get(0); // ClassCastException
    //String s = String.valueOf(stringLists[0].get(0));
    log.info("s:{}", s);
  }

  @Test
  void testToArray() {
    Integer[] arrays = toArray(1, 2, 3);
    Object[] objects = toArray(1, 2, "3");
  }

  // UNSAFE - Exposes a reference to its generic parameter array!
  <T> T[] toArray(T... args) {
    return args;
  }

  @Test
  void testToArrayV1() {
    String[] strs = {"1", "2"};
    toArrayV1(strs);
  }

  void toArrayV1(Object[] args) {
    log.info("args:{}", Arrays.toString(args));
  }

  @Test
  void toArrayV2() {
    List<Object> list = List.of("!", "@");
    //List<String> list = List.of("!", "@");
    toArrayV2(list);
  }

  void toArrayV2(List<Object> args) {
    log.info("args:{}", args);
  }
}
