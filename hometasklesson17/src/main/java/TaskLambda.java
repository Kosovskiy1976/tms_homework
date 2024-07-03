import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class TaskLambda {
    public static void main(String[] args) {

//      Task 1

        String string = "5000 BYN";

        Function<String, String> function = (str) -> {
            int i = str.indexOf(" ");
            String substring = str.substring(0, i);
            Integer sum = Integer.valueOf(substring);
            Integer sumDollars = sum / 3;
            return sumDollars + " Dollars";
        };

        System.out.println(function.apply(string));

//        Task 2
        Consumer<String> consumer = (str) -> {
            int i = str.indexOf(" ");
            String substring = str.substring(0, i);
            Integer sum = Integer.valueOf(substring);
            Integer sumDollars = sum / 3;
            System.out.println(sumDollars + " Dollars");
        };
        consumer.accept(string);

//        Task 3

        Supplier<StringBuilder> supplier = () -> {
            System.out.println("Enter line:");
            Scanner scanner1 = new Scanner(System.in);
            String line = scanner1.next();
            StringBuilder linerevers = new StringBuilder(line);
            return linerevers.reverse();
        };

        System.out.println(supplier.get());

    }
}
