import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private String sex;
    private int age;
    private List<String> items;

    public Student(String name, String sex, int age, List<String> items) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public List<String> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
