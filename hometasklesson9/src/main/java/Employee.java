public abstract class Employee {
    private String name;
    private String sername;
    private Integer lenthservis;
    private Title title;

    public Employee(String name, String sername, Integer lenthservis, Title title) {
        this.name = name;
        this.sername = sername;
        this.lenthservis = lenthservis;
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public Title getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                        ", sername='" + sername + '\'' +
                        ", lenthservis=" + lenthservis +
                        ", title=" + title;
    }
}
