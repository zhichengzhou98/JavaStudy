package effectiveJava.chapter2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-06-20 17:04
 */
public class JDBCConnection {

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/spring_ai", "root", "abc123");
        ResultSet resultSet = connection.prepareStatement("select * from user").executeQuery();
        System.out.println(resultSet);
    }

}
