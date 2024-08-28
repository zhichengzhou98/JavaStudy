package design_pattern.factory_method.state;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-08-28 15:54
 */
public class ConcreteStateA extends State{

  @Override
  public void handle(Context context) {
    System.out.println("关");
    //设置下一个状态为B
    context.setState(new ConcreteStateB());
  }
}
