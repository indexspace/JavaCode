/**
 * @author 28388
 */

public class Main {

    static int val;

    public static void getVal(){
        System.out.println(val);
    }

    public static void init(){
        val = 1;
        System.out.println("003");
    }

    public static void main(String[] args) {

        FlyWeightPool pool = FlyWeightPool.getInstance();

        User user1 = pool.getUser();
        System.out.println("user1 = " + user1);

        User user2 = pool.getUser();
        System.out.println("user2 = " + user2);

        user1.setActive(true);

        User user3 = pool.getUser();
        System.out.println("user3 = " + user3);
    }

}