import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите целое число");
        int  Number = scanner.nextInt();

        for (int i = 0; i <= Number; i++) {
            if ((i % 3 == 0) & (i % 2 == 1))
            {System.out.println(i);};
        }
        }
}
