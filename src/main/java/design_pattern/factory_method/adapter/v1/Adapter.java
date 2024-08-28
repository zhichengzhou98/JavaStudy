package design_pattern.factory_method.adapter.v1;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-08-28 18:05
 */
public class Adapter extends Target {
  private Adaptee adaptee;

  public Adapter(Adaptee adaptee) {
    this.adaptee = adaptee;
  }

  @Override
  public void request() {
    adaptee.specificRequest();
  }
}
