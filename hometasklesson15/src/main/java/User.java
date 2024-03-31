import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class User implements Comparable<User> {

    private String name;
    private Integer lenthOfServis;
    private ArrayList<String> taskList;

    public User(String name, int lenthOfServis, ArrayList<String> taskList) {
        this.name = name;
        this.lenthOfServis = lenthOfServis;
        this.taskList = taskList;
    }

    @Override
    public int compareTo(User o) {
        return o.lenthOfServis - this.lenthOfServis;
    }

    public String getName() {
        return name;
    }

    public int getLenthOfServis() {
        return lenthOfServis;
    }

    public ArrayList<String> getTaskList() {
        return taskList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lenthOfServis=" + lenthOfServis +
                ", taskList=" + taskList +
                '}';
    }
}
