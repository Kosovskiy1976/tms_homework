public abstract class Employee {

    private String name;
    private String surname;
    private int lenthservis;
    private JobTitle title;

    public Employee(String name, String surname, int lenthservis, JobTitle title) {
        this.name = name;
        this.surname = surname;
        this.lenthservis = lenthservis;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", lenthservis=" + lenthservis +
                ", title=" + title +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getLenthservis() {
        return lenthservis;
    }

    public void setLenthservis(int lenthservis) {
        this.lenthservis = lenthservis;
    }

    public JobTitle getTitle() {
        return title;
    }

    public void setTitle(JobTitle title) {
        this.title = title;
    }
}
