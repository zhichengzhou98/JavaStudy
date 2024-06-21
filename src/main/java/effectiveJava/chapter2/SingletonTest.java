package effectiveJava.chapter2;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-06-21 11:25
 */
public class SingletonTest {

    public static void main(String[] args) {
        Employee employee1 = Employee.instance;
        Employee employee2 = Employee.instance;
        System.out.println(employee2 == employee1);
    }
}

class Employee {
    public static Employee instance = new Employee();
    private Employee() {
    }
}
