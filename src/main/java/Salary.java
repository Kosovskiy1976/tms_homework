import java.util.Scanner;

public class Salary {
    public static void main(String[] args) {

        User Chief = new User("Андрей", Status.DIRECTOR, 15);
        User Manager = new User("Константин", Status.HR, 20);
        User Worker = new User("Сергей", Status.WORKER, 30);

        System.out.println("Зарплата Андрея:" + Chief.calculation());
        System.out.println("Зарплата Константина:" + Manager.calculation());
        System.out.println("Зарплата Сергея:" + Worker.calculation());

        System.out.println("Введите дополнительную зарплату:");
        Scanner scanner = new Scanner(System.in);
        int add = scanner.nextInt();

        System.out.println("Зарплата Андрея c дополн.:" + Chief.calculadd(add));
        System.out.println("Зарплата Константина c дополн.::" + Manager.calculadd(add));
        System.out.println("Зарплата Сергея c дополн.::" + Worker.calculadd(add));
    }
}