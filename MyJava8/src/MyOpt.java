import java.util.Optional;

public class MyOpt {
    public static void main(String [] args) {
        Optional<Integer> opt1 = Optional.ofNullable(1);
        Optional<Integer> opt2 = Optional.ofNullable(2);
        Optional<Integer> opt3 = Optional.ofNullable(null);

        opt1.ifPresent(System.out::println);
        opt2.ifPresent(System.out::println);

    }
}
