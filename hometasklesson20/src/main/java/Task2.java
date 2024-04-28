import java.sql.Array;
import java.util.Arrays;
import java.util.OptionalInt;

public class Task2 {
    public static void main(String[] args) {

        int[] numbers = {2,60,6,7,3,9,30,46,35,44};

        Thread thread3 = new Thread(() -> {
            int max = Arrays.stream(numbers).max().getAsInt();
            System.out.println("max = " + max);
        });

        Thread thread4 = new Thread(() -> {
            int min = Arrays.stream(numbers).min().getAsInt();
            System.out.println("min = " + min);
        });

        thread3.start();
        thread4.start();

    }
}
