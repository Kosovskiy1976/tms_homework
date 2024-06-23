import java.util.Arrays;
import java.util.Scanner;

public class Array1 {
    public static void main(String[] args) {
        System.out.println("Введите длину массива");
        Scanner scanner = new Scanner(System.in);
                int length = scanner.nextInt();
      //System.out.println(length);
        float sum = 0;
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (10 * ( Math.random()));
            // System.out.println(arr[i]);
            sum = sum + arr[i];
        }
        System.out.println("Массив:  " + Arrays.toString(arr));
        System.out.println("Среднее арифметическое элементов массива = " + (sum/(arr.length)));

        int[] arrrev = new int[length];
            for (int i = 0; i < arr.length; i++) {
            arrrev[i] = arr[(length - 1 - i)];

            }
        System.out.println("Массив в обратном порядке:  " + Arrays.toString(arrrev));

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < (arr.length ); j++) {
                if (arr[i] == arr[j]) {
                    System.out.println("Повторяющийся элемент: " + arr[j]);
                   break;
                }

            }
        }
    }
}
