public class Main {
    public static void main(String[] args) {
        //     ---------- task 1 ---------------------
        Cat cat = new Cat();
        Dog dog = new Dog();

        Animal animal = new Animal();
        animal.say(cat);
        animal.say(dog);

        // -------------- task 2 ---------------------
        Computer hp = new HP();
        Computer mac = new Mac();
        hp.getClassName();
        mac.getClassName();

    }
}
