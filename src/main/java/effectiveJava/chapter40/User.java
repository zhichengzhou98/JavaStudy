package effectiveJava.chapter40;

import java.util.Objects;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-09-19 17:46
 */
@Slf4j
public class User extends People implements Animal{
  String name;

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    User user = (User) o;
    return Objects.equals(name, user.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public void getName() {
    log.info("name: {}", this.name);
  }

  @Override
  public void say() {
    log.info("say");
  }
}
