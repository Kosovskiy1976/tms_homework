import java.util.Scanner;

public class TestPerson {

    public static void main(String[] args) {

        System.out.println("Введите логин");
        Scanner scanner = new Scanner(System.in);
        String login = scanner.nextLine();

        System.out.println("Введите пароль");
        String password = scanner.nextLine();

        System.out.println("Подтвердите пароль");
        String confirmpassword = scanner.nextLine();

        Person.controlPerson(login, password, confirmpassword);

    }
}
