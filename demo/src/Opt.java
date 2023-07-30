import java.sql.SQLOutput;
import java.util.Optional;

public class Opt {

    public static void main(String[] args) {
        User user1 = new User("czp", 21, true);
        User user2 = null;

        Optional<User> optional1 = Optional.ofNullable(user1);
        Optional<User> optional2 = Optional.ofNullable(user2);

        Optional<String> optional3 = Optional.ofNullable("abc");
        Optional<String> optional4 = Optional.ofNullable(null);


        optional1.ifPresent(e -> System.out.println("user1= " + e.toString()));
        optional2.ifPresent(e -> System.out.println("user2= " + e.toString()));
        optional3.ifPresent(e -> System.out.println("user3= " + e));
        optional4.ifPresent(e -> System.out.println("user4= " + e));
        System.out.println();

    }
}
