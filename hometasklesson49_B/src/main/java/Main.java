import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        String name = "LTD";
        float purchasePrice = 600;
        LocalDate timeToBuy = LocalDate.of(2020, 4, 14);

        BicycleFactory bicycleFactory = new BicycleFactory();

        Bicycle bicycle = bicycleFactory.create(name, purchasePrice, timeToBuy);

        System.out.println(bicycle);
    }
}
