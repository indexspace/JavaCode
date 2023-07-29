import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyClass {
    public static void main(String[] args) throws Exception {

        Class<?> userClass = Class.forName("User");

        Constructor<?> constructor = userClass.getConstructor(String.class, int.class);
        User userIns = (User)constructor.newInstance("zhangSan", 18);
        Class<? extends User> aClass = userIns.getClass();

        Method getName = userClass.getMethod("getName");
        System.out.println("getName.invoke(userIns) = " + getName.invoke(userIns));
    }
}
