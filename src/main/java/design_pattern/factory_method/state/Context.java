package design_pattern.factory_method.state;

import lombok.Data;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-08-28 15:55
 */
@Data
public class Context {
  private State state;

  public Context(State state) {
    this.state = state;
  }

  //对请求进行处理并转化下一个状态
  public void request() {
    this.state.handle(this);
  }
}
