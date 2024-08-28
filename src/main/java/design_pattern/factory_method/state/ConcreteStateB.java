package design_pattern.factory_method.state;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-08-28 15:57
 */
public class ConcreteStateB extends State{
  @Override
  public void handle(Context context) {
    System.out.println("开");
    context.setState(new ConcreteStateA());
  }
}
