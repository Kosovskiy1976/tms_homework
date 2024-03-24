public class Person {
    public static boolean controlPerson(String login, String password, String confirmpassword) {

        boolean log = false;
        boolean pass = false;

        try {
            if ((login.length() >= 20) || (login.contains(" "))) {
                throw new WrongLoginException();
            } else {System.out.println("login is Ok");
            log = true; }
        } catch (WrongLoginException e) {
            System.out.println("login is wrong");
        }

        boolean containsNumber = false;
        for (int i = 0; i < 10; i++) {
            if (password.contains("" + i)) {
                containsNumber = true;
                break;
            }
        }

        try {
            if ((password.length() >= 20) || (password.contains(" "))
                    || !(password.equals(confirmpassword)) || !(containsNumber)) {
                throw new WrongPasswordException("password is wrong");
            } else {
                System.out.println("password is Ok");
                pass = true;
            }
        } catch (WrongPasswordException e) {
            System.out.println(e.getMessage());
        }

        return (log & pass);
    }
}
