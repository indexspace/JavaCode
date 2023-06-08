package pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pojo.Cat;

import java.util.*;


@Component
public class Student {
    private String name;
    private String sno;
    private int age;
    private Cat cat;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "pojo.Student{" +
                "name='" + name + '\'' +
                ", sno='" + sno + '\'' +
                ", age=" + age +
                ", cat=" + cat.toString() +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getSno() {
        return sno;
    }

    public int getAge() {
        return age;
    }
    @Value("lisi")
    public void setName(String name) {
        this.name = name;
    }
    @Value("047116")
    public void setSno(String sno) {
        this.sno = sno;
    }
    @Value("21")
    public void setAge(int age) {
        this.age = age;
    }

    public Cat getCat() {
        return cat;
    }
    @Autowired
    public void setCat(Cat cat) {
        this.cat = cat;
    }
}
