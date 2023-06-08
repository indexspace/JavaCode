package pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Cat {
    public String name;

    public String getName() {
        return name;
    }
    @Value("sansan")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "pojo.Cat{" +
                "name='" + name + '\'' +
                '}';
    }

    public Cat() {
    }

    public Cat(String name) {
        this.name = name;
    }
}
