public class SingletonTest {
    public static void main(String[] args) {

        Singleton1 instance11 = Singleton1.getInstance();
        Singleton1 instance12 = Singleton1.getInstance();

        Singleton2 instance21 = Singleton2.getInstance();
        Singleton2 instance22 = Singleton2.getInstance();

        instance11.printName();
        instance12.printName();

        instance21.printName();
        instance22.printName();

        System.out.println("instance11.equals(instance12) = " + instance11.equals(instance12));

        System.out.println("instance21.equals(instance22) = " + instance21.equals(instance22));

    }
}

class Singleton1 {
    private Singleton1() {}

    private static Singleton1 instance = null;

    public static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }

    public void printName() {
        String name = "singleton1";
        System.out.println(name);
    }
}

class Singleton2 {
    private Singleton2() {}

    private static final Singleton2 instance = new Singleton2();

    public static Singleton2 getInstance() {
        return instance;
    }

    public void printName() {
        String name = "singleton2";
        System.out.println(name);
    }
}


