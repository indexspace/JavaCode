import java.util.ArrayList;

public class StreamAPI {

    public static void main(String[] args){

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            arrayList.add(i);
        }

        arrayList.stream()
                .filter(e -> e>90)
                .filter(e -> e%2 == 0)
                .map(e -> e-90)
                .forEach(System.out::println);
    }
}
