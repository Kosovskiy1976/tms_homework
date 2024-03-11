import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название месяца");
        String M = scanner.next();
        if (M.equals ("январь") || M.equals("февраль") || M.equals ("декабрь"))
            { System.out.println("Сезон - " + "Зима");};
        if (M.equals ("март") || M.equals ("апрель") || M.equals ("май")) {
            System.out.println("Сезон - " + "Весна");    };
        if (M.equals ("июнь") || M.equals ("июль") || M.equals ("август")) {
            System.out.println("Сезон - " + "Лето");         }        ;
        if (M.equals ("сентябрь") || M.equals ("октябрь") || M.equals ("ноябрь")) {
            System.out.println("Сезон - " + "Осень");   }    ;
    }
}
