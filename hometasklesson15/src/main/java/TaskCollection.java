import java.sql.Array;
import java.util.*;

public class TaskCollection {
    public static void main(String[] args) {

        User user1 = new User("Andrew", 23, new ArrayList<>(Arrays.asList("task1", "task2", "task3")));
        User user2 = new User("Lena", 34, new ArrayList<>(Arrays.asList("task1", "task2")));
        User user3 = new User("Andrew", 35, new ArrayList<>(Arrays.asList("task2", "task3")));

        List<User> usersList = new ArrayList<>();
        usersList.add(user1);
        usersList.add(user2);
        usersList.add(user3);
        List<User> setUsers2task = new ArrayList<>();
        for (User user : usersList) {
            if (user.getTaskList().size() > 2) {
                setUsers2task.add(user);
            }
        }
        System.out.println();
        System.out.println("Пользователи, у который количество задач больше 2:");
        System.out.println(setUsers2task);
        System.out.println();

        Set<User> treeUsers = new TreeSet<>();
        treeUsers.add(user1);
        treeUsers.add(user2);
        treeUsers.add(user3);
        System.out.println("Пользователи по стажу работы (от большего к меньшему):");
        System.out.println(treeUsers);
        System.out.println();

        Set<User> usersName = new HashSet<>();
        usersName.add(user1);
        usersName.add(user2);
        usersName.add(user3);
        List<String> names = new ArrayList<>();
        Iterator<User> iterator = usersName.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            names.add(user.getName());
        }
        System.out.println("Уникальные имена пользователей:");
        System.out.println(names);


    }
}
