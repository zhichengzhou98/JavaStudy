package effectiveJava.chapter2;

import effectiveJava.chapter2.Student.StudentBuilder;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-06-21 10:45
 */
@Builder
@Data
class Student {

    private final int age;
    @NonNull
    private final String name;
}

public class StudentTest {
    public static void main(String[] args) {
        StudentBuilder builder = new StudentBuilder();
        Student student = builder.name("123").build();
        System.out.println(student);
    }
}
