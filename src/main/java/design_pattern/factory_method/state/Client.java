package design_pattern.factory_method.state;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-08-28 16:08
 */
public class Client {
  public static void main(String[] args) {
    Context context = new Context(new ConcreteStateA());
    context.request();
    context.request();
  }
}
