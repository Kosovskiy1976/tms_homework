import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class TaskLambda {
    public static void main(String[] args) {

//      Task 1

        Function<String, String> function = (str) -> {
            Integer sum = Integer.valueOf(str);
            Integer sumDollars = sum / 3;
            return sumDollars + " Dollars";
        };

        System.out.println("Enter sum (in BYN):");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();

        System.out.println(function.apply(string));

//        Task 2
        Consumer<String> consumer = (str) -> {
            Integer sum = Integer.valueOf(str);
            Integer sumDollars = sum / 3;
            System.out.println(sumDollars + " Dollars");
        };
        consumer.accept(string);

//        Task 3
        System.out.println("Enter line:");
        Scanner scanner1 = new Scanner(System.in);
        String line = scanner.next();

        Supplier<StringBuilder> supplier = () -> {
            String line1 = line;
            StringBuilder linerevers = new StringBuilder(line1);
            return linerevers.reverse();
        };

        System.out.println(supplier.get());

    }
}
