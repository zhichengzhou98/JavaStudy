package effectiveJava.chapter30;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Stack;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zc.zhou
 * @Description 31 使用限定通配符来增加 API 的灵活性
 * @create 2024-09-10 16:48
 */
@Slf4j
public class GenericWildcard {

  MyStack<Number> myStack;

  @BeforeEach
  void init() {
    myStack = new MyStack<>();
    myStack.push(1);
  }

  @Test
  void testPush() {
    Iterable<Integer> list = List.of(1, 2);
    myStack.pushAll(list);
  }

  @Test
  void testPopAllV1() {
    Collection<Number> list = new ArrayList<>();
    log.info("{}", list);
    myStack.popAllV1(list);
    log.info("{}", list);
  }

  @Test
  void testPopAll() {
    Collection<Object> list = new ArrayList<>();
    log.info("{}", list);
    myStack.popAll(list);
    log.info("{}", list);
  }
}

class MyStack<E> extends Stack<E> {
  public void pushAll(Iterable<? extends E> src) {
    for (E e : src) {
      push(e);
    }
  }

  public void popAll(Collection<? super E> collection) {
    while (!isEmpty()) {
      collection.add(pop());
    }
  }

  public void popAllV1(Collection<E> collection) {
    while (!isEmpty()) {
      collection.add(pop());
    }
  }

  public void pushAllV1(Iterable<E> src) {
    for (E e : src) {
      push(e);
    }
  }
}
