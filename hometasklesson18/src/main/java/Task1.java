import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.min;

@Data
@AllArgsConstructor
public class Task1 {
    public static void main(String[] args) {


        Shop shop1 = new Shop(1, Citys.Minsk,"Marksa",3456289);
        Shop shop2 = new Shop(2, Citys.Brest, "Lenina",4678978);
        Shop shop3 = new Shop(3, Citys.Berlin, "Brunostr.",5423658);
        Manufacturer mercedes = new Manufacturer("Mercedes", Cantris.Germany);
        Manufacturer ltd = new Manufacturer("LTD", Cantris.Belarus);

        Product MercedesA = new Product("MercedesA", 30000, Item.AUTO, true,
                new ArrayList<>(List.of(shop1, shop2)), mercedes);
        Product MercedesC = new Product("MercedesC", 40000, Item.AUTO, false,
                new ArrayList<>(List.of(shop1, shop3)), mercedes);
        Product ltd20 = new Product("LTD20", 700, Item.BIKE, true,
                new ArrayList<>(List.of(shop2, shop3)), ltd);
        Product ltd30 = new Product("LTD30", 800, Item.BIKE, true,
                new ArrayList<>(List.of(shop1, shop2)), ltd);

        List<Product> products = new ArrayList<>(List.of(MercedesA, MercedesC, ltd20, ltd30));

//        1) определить самый дорогой и дешевый товар
        Product productMinCost = products.stream().min((p1, p2) -> p1.getCost() - p2.getCost()).get();
        System.out.println("the cheapest product:");
        System.out.println(productMinCost);
        Product productMaxCost = products.stream().max((p1, p2) -> p1.getCost() - p2.getCost()).get();
        System.out.println("the most expensive product:");
        System.out.println(productMaxCost);

//        2) найти все товары которые возможно доставить до покупателя
        List<Product> listOfDeliveryPossibility = products.stream()
                .filter(Product::getDeliveryPossibility)
                .toList();
        System.out.println("goods that can be delivered to the buyer:");
        System.out.println(listOfDeliveryPossibility);

//        3) посчитать среднюю стоимость товара указанной категории
        OptionalDouble averageCost = products.stream()
                .filter(product -> product.getItem().equals(Item.AUTO))
                .mapToInt(Product::getCost)
                .average();
        if (averageCost.isPresent()) {
            System.out.println("averaging the cost for this category: " + averageCost.getAsDouble());
        } else System.out.println("price is not determined");

//        4) найти все товары определенного производителя
        List<Product> listOfManufacturer = products.stream()
                .filter(product -> product.getManufacturer().equals(mercedes))
                .toList();
        System.out.println("all products from this manufacturer:");
        System.out.println(listOfManufacturer);

//        5) найти все названия производителей указанной страны
        Set<Manufacturer> manufacturersOfCountry = products.stream()
                .filter(product -> product.getManufacturer().getCantry().equals(Cantris.Belarus))
                .map(Product::getManufacturer)
                .collect(Collectors.toSet());
        System.out.println("all manufacturers in the country:");
        System.out.println(manufacturersOfCountry);

//        6) найти все магазины конкретного города
        Set<Shop> shopsOfCity = products.stream()
                .flatMap(product -> product.getListOfShops().stream())
                .filter(shop -> shop.getCity().equals(Citys.Minsk))
                .collect(Collectors.toSet());
        System.out.println("all shops in the city:");
        System.out.println(shopsOfCity);

//        7) найти адрес магазина по указанному номеру телефона
        Set<Shop> shopOfNumber = products.stream()
                .flatMap(product -> product.getListOfShops().stream())
                .filter(shop -> shop.getPhoneNumber() == 4678978)
                .collect(Collectors.toSet());
        System.out.println(shopOfNumber);

//        8) все товары указанного номера магазина

        Set<Product> productsOfShop = products.stream()
                .filter(product -> product.getListOfShops().stream()
                        .anyMatch(shop -> shop.getNumber()==2))
                .collect(Collectors.toSet());
        System.out.println("all products of the specified store number:");
        System.out.println(productsOfShop);


//        9) составить map где ключ это номер магазина, а значение - это номер телефона данного магазина
        Map<Integer, Integer> mapShop = products.stream()
                .flatMap(product -> product.getListOfShops().stream())
                .distinct()
                .collect(Collectors.toMap(Shop::getNumber, Shop::getPhoneNumber));
        System.out.println(mapShop);


//        10) узнать все ли товары указанной категории можно доставить до покупателя
        boolean allProduktOfItem = products.stream()
                .filter(product -> product.getItem().equals(Item.AUTO))
                .allMatch(Product::getDeliveryPossibility);
        System.out.println("can all goods of the specified category be delivered to the buyer?");
        System.out.println(allProduktOfItem);

//        11) посчитать количество магазинов
        int numberOfStores = products.stream()
                .flatMap(product -> product.getListOfShops().stream())
                .collect(Collectors.toSet()).size();
        System.out.println("number of stores:");
        System.out.println(numberOfStores);

//        12) вывести товары отсортированные по стоимости (от большего к меньшему)
        List<Product> coolectionOfProduct = products.stream()
                .sorted((p1, p2) -> p2.getCost() - p1.getCost())
                .collect(Collectors.toList());
        System.out.println(coolectionOfProduct);



    }
}
