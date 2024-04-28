import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Locale;

@AllArgsConstructor
@Data

public class Product {
    private String name;
    private Integer cost;
    private Item item;
    private Boolean deliveryPossibility;
    private List<Shop> listOfShops;
    private Manufacturer manufacturer;

    @Override
    public String toString() {
        return "Product " + name;
    }
}
