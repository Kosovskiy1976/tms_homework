import java.util.Arrays;
import java.util.Scanner;

public class Array2 {

        public static void main(String[] args) {
            System.out.println("Введите длину массива");
            Scanner scanner = new Scanner(System.in);
            int length = scanner.nextInt();

            int[] arr = new int[length];
            for (int i = 0; i < arr.length; i++) {
                System.out.println("Введите " + i + " -й элемент массива");
                arr[i] = scanner.nextInt();;
                            }
            System.out.println("Массив:  " + Arrays.toString(arr));




        }




}
