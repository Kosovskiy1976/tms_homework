import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task2 {
    public static void main(String[] args) {

//        1) Найти среднее значение первых 10 чисел.
        Double average = Stream.iterate(1, val -> val + 1)
                .limit(10)
                .mapToInt(n -> n)
                .average().getAsDouble();
        System.out.println(average);

//        2) Пропустить 5 чисел и вывести следующие 10 чисел, которые делятся на 3 без остатка
        List<Integer> list = Stream.iterate(1, n -> n + 1)
                .filter(n -> n % 3 == 0)
                .skip(5)
                .limit(10)
                .toList();
        System.out.println(list);

//        3) Посчитать сумму 20 подряд идущих чисел
        int sum = IntStream.iterate(1, n -> n + 1)
                .limit(20)
                .sum();
        System.out.println(sum);

    }
}
