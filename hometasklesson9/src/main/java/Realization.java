public class Realization {
    public static void main(String[] args) {
        Director director1 = new Director("Andrew","Ivanov",12);
        Worker worker1 = new Worker("Vasja","Petrov",30);
        Worker worker2 = new Worker("Vova","Sidorov",15);
        Worker worker3 = new Worker("Ivan","Limonov",20);

        System.out.println(director1.toString());
        System.out.println(worker1.toString());

    }
}
