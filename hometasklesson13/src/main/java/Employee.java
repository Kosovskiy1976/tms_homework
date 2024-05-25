public abstract class Employee {

    private String name;
    private String surname;
    private int lenthservis;
    private Strukture strukture;

    public Employee(String name, String surname, int lenthservis, Strukture strukture) {
        this.name = name;
        this.surname = surname;
        this.lenthservis = lenthservis;
        this.strukture = strukture;
    }
}
