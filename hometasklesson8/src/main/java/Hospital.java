import java.util.Scanner;

public class Hospital {
    public static void main(String[] args) {

        System.out.println("Введите имя пациента:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();

        System.out.println("Введите для пациента план лечения:");
        Scanner scanner1 = new Scanner(System.in);
        int plan = scanner1.nextInt();

        Patient patient1 = new Patient(name,plan);

        Therapist therapist = new Therapist(patient1);
        therapist.getDoctor();

    }
}



