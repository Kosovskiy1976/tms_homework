import java.time.LocalDate;

public class BicycleFactory {

    Bicycle create(String name, double purchasePrice, LocalDate timeToBuy){
        return new Bicycle(name,
                manufacturerIdentification(name),
                    purchasePrice,
                        calculateCurrentCost(timeToBuy, purchasePrice),
                            timeToBuy,
                                calculateAge(timeToBuy));
    }

    public Integer calculateAge(LocalDate timeToBuy){
        Integer age = LocalDate.now().getYear() - timeToBuy.getYear();
        return age;
    }

    public String manufacturerIdentification(String name){

        if (name.equals("LTD")) { return "LTD";}
        if (name.equals("Trek")) { return "Trek Bicycle Corporation";}

        return "Not defined";
    }

    public double calculateCurrentCost(LocalDate timeToBuy, double purchasePrice){
        Integer age = LocalDate.now().getYear() - timeToBuy.getYear();
        double currentCost = purchasePrice * (1 - (10 * age)/100.);
        if (currentCost > 0) {return currentCost;}
        return 0;
    }

}
