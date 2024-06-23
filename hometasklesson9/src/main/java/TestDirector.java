import java.util.Scanner;

public class TestDirector {

    public static void main(String[] args) {

        Director director1 = new Director("Andrew", "Kos", 23, Title.DIRECTOR);
        Worker worker1 = new Worker("Ivan", "Lom", 24, Title.WORKER);
        Worker worker2 = new Worker("Illa", "Kot", 10, Title.WORKER);
        Worker worker3 = new Worker("Dima", "Sun", 15, Title.WORKER);

        System.out.println();
        System.out.println(director1);
        System.out.println(worker1);
        System.out.println(worker2);
        System.out.println(worker3);
        System.out.println();

        director1.assign(worker1);
        director1.assign(worker2);
        System.out.println(director1.toString());
        System.out.println();

        Director director2 = new Director("Pavel", "Lis", 37, Title.DIRECTOR);
        director2.assign(worker3);
        director1.assign(director2);
        System.out.println(director1.toString());
        System.out.println();

        System.out.println("Enter name:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        ExistSubordinates existSubordinates = new ExistSubordinates();
        if (existSubordinates.existSubordinates(director1, name)) {
            System.out.println("The director has subordinates with this name");
        } else System.out.println("The director has no subordinates with this name");

    }

}
