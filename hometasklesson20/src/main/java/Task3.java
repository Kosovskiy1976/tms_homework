import java.util.stream.Stream;

public class Task3 {
    public static void main(String[] args) {

        Thread thread5 = new Thread(() -> {
            Stream.iterate(1, n -> n + 1);
        });

        thread5.setDaemon(true);
        thread5.start();


    }
}
