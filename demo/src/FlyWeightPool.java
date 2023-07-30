import java.util.HashSet;
import java.util.Set;

public class FlyWeightPool {
    private FlyWeightPool() {
        for(int i = 0; i < 3; i++) {
            pool.add(new User("00"+i, 20, true));
        }
    }

    private static final FlyWeightPool instance = new FlyWeightPool();

    public static FlyWeightPool getInstance() {
        return instance;
    }

    private Set<User> pool = new HashSet<User>();

    public User getUser() {
        for(User u : pool) {
            if(u.isActive()) {
                u.setActive(false);
                return u;
            }
        }
        return null;
    }

}
