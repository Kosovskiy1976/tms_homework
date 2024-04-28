import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class TaskList {
    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();

        Student st1 = new Student("Andrew", "M", 19, java.util.List.of("Math", "Programming", "History"));
        Student st2 = new Student("Lena", "W", 21, java.util.List.of("Math", "Literature"));
        Student st3 = new Student("Jan", "M", 22, java.util.List.of("Programming"));

        students.add(st1);
        students.add(st2);
        students.add(st3);

        ArrayList<Student> listMan = new ArrayList<>();
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getSex().equals("M")) {
                listMan.add(student);
            }
        }
        System.out.println();
        System.out.println("Список студентов-юношей:");
        System.out.println(listMan);

        ArrayList<Student> listAge = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getAge() > 20) {
                listAge.add(student);
            }

        }
        System.out.println();
        System.out.println("Список студентов старше 20 лет:");
        System.out.println(listAge);

        ArrayList<Student> listVisit = new ArrayList<>();
        for (Student student: students) {
            if (student.getItems().size() < 2) {
                listVisit.add(student);
            }
        }
        System.out.println();
        System.out.println("Список студентов, посещающих менее 2-х занятий:");
               System.out.println(listVisit);

        ArrayList<Student> listProgramming = new ArrayList<>();
        for (Student student: students) {
            if (student.getItems().contains("Programming")) {
                listProgramming.add(student);
            }
        }
        System.out.println();
        System.out.println("Список студентов изучающих программирование:");
        System.out.println(listProgramming);
    }
}
