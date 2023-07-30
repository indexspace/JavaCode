public class User {
    private String name;
    private int age;

    private boolean Active;


    public User(String name, int age, boolean Active) {
        this.name = name;
        this.age = age;
        this.Active = Active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        Active = active;
    }
}
