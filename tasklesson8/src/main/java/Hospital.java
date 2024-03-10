import java.util.Scanner;

public class Hospital {
    public static void main(String[] args) {
        System.out.println("Введите для пациента план лечения:");
        Scanner scanner = new Scanner(System.in);
        int plan = scanner.nextInt();
        Patient patient1 = new Patient(plan);
        Doctor.Therapist.getDoctor(patient1);

    }
}



