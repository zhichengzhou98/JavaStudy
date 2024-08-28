package design_pattern.factory_method.adapter.v1;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-08-28 18:02
 */
public class Client {
  private Target target;

  public Client(Target target) {
    this.target = target;
  }

  public void handleRequest() {
    target.request();
  }

  public static void main(String[] args) {
    Client client = new Client(new Target());
    client.handleRequest();
    //处理特殊请求
    Target adapter = new Adapter(new Adaptee());
    client = new Client(adapter);
    client.handleRequest();
  }
}
