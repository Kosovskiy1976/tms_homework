import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число < 10 000");
        int N = scanner.nextInt();
        int X = N / 1000;
        System.out.println("Количество тысяч:"+X);
        int Y = (N - (X * 1000)) / 100;
        System.out.println("Количество сотен:"+Y);
        int Z = (N - (X * 1000) - (Y * 100)) / 10;
        System.out.println("Количество десятков:"+Z);
        int W = (N - (X * 1000) - (Y * 100) - (Z * 10));
        System.out.println("Количество единиц:"+W);
        int I = 0;
        if (X != 0) {I = 4;};
        if (X == 0 && Y != 0) {I = 3;};
        if (X == 0 && Y == 0 && Z != 0) {I = 2;};
        if (X == 0 && Y == 0 && Z == 0) {I = 1;};
        System.out.println("Количество знаков:"+I);
    }



}
