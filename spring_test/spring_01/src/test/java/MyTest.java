import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Cat;
import pojo.Student;

public class MyTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        Cat cat = (Cat) context.getBean("cat");
        System.out.println(cat.toString());

        Student student = (Student) context.getBean("student");
        System.out.println(student.toString());
    }
}
