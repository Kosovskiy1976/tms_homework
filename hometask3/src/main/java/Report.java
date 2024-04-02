public class Report {

    public static void main(String[] args) {
        Cat Cat1 = new Cat("Frend", 10, "black");
        Cat1.print();
        Cat Cat2 = new Cat("Frend", 10);
        Cat2.print();
        Cat1.newname("Катя");
        Cat1.print();
    }




}
