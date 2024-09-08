import factory.Impl.LTDAbstractFactoryImpl;
import factory.Impl.MyAbstractFactoryImpl;

public class Main {

    public static void main(String[] args) {

        BicycleService bicycleService = new BicycleService();

        Bicycle myBicycle = bicycleService.createBicycle(new MyAbstractFactoryImpl());

        Bicycle bicycleLTD = bicycleService.createBicycle(new LTDAbstractFactoryImpl());

        System.out.println(myBicycle);

        System.out.println(bicycleLTD);
    }
}
