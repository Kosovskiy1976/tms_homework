public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Cat cat = new Cat("Mursik");
        Person person = new Person("Andrew", 20, 1000, cat);
        System.out.println(person);

        System.out.println("hashCode = " + person.hashCode());

        Person person1 = person.clone();
        person1.setName("Dima");
        System.out.println(person1);

        System.out.println(person.equals(person1));
    }
}
