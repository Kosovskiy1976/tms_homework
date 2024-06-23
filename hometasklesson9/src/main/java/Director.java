import java.util.ArrayList;

public class Director extends Employee {

    private ArrayList<Employee> subordinates;

    public Director(String name, String sername, Integer lenthservis, Title title) {
        super(name, sername, lenthservis, title);
        this.subordinates = new ArrayList<>();
    }

    public void assign(Employee employee) {
        subordinates.add(employee);
    }

    @Override
    public String toString() {
        return "Director " + super.toString() + " { " +
                "subordinates=" + subordinates +
                '}';
    }

    public ArrayList<Employee> getSubordinates() {
        return subordinates;
    }
}
