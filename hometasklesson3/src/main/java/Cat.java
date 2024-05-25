public class Cat {

    public String name;
    public int age;
    public String breed;
    public Cat(String name1, int age1, String breed1) {
        name = name1;
        age = age1;
        breed = breed1;

    }
    public Cat(String name1, int age1) {
        this (name1, age1, "Без породы");
    }
    public void print() {
        System.out.println(name);
        System.out.println(age);
        System.out.println(breed);
    }
    public String newname(String name2) {
        name = name2;
        return name;
    }
}
