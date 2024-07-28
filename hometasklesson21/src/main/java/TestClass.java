import org.apache.commons.lang3.math.NumberUtils;

public class TestClass {
    public static void main(String[] args) {
        int compare1 = NumberUtils.compare(30, 20);
        System.out.println(compare1);
        int compare2 = NumberUtils.compare(20, 30);
        System.out.println(compare2);
        int compare3 = NumberUtils.compare(20, 20);
        System.out.println(compare3);
    }
}
