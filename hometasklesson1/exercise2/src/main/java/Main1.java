import java.util.Scanner;
public class Main1 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите название месяца");
            String M = scanner.next();
            //       switch (M.equals) {
            switch (M) {
                case "январь":
                    System.out.println("Сезон - " + "Зима");
                    break;
                case "февраль":
                    System.out.println("Сезон - " + "Зима");
                    break;
                case "март":
                    System.out.println("Сезон - " + "Весна");
                    break;
                case "апрель":
                    System.out.println("Сезон - " + "Весна");
                    break;
                case "май":
                    System.out.println("Сезон - " + "Весна");
                    break;
                case "июнь":
                    System.out.println("Сезон - " + "Лето");
                    break;
                case "июль":
                    System.out.println("Сезон - " + "Лето");
                    break;
                case "август":
                    System.out.println("Сезон - " + "Лето");
                    break;
                case "сентябрь":
                    System.out.println("Сезон - " + "Осень");
                    break;
                case "октябрь":
                    System.out.println("Сезон - " + "Осень");
                    break;
                case "ноябрь":
                    System.out.println("Сезон - " + "Осень");
                    break;
                case "декабрь":
                    System.out.println("Сезон - " + "Зима");
                    break;
            }
        }


}
