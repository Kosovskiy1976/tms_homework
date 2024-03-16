


public class Person implements Cloneable {

    private String name;
    private int age;
    private int salary;
    private Cat cat;

    public Person(String name, int age, int salary, Cat cat) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.cat = cat;
    }

    public String toString() {
        return "Person with name " + name + " age " + age + " salary " + salary
                + cat.toString();
    }

    @Override
    public int hashCode() {
        return name.length() + age + salary;
    }

    @Override
    protected Person clone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }

    public void setName(String name) {
        this.name = name;
    }
}
