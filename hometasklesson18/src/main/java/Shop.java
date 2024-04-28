import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor

public class Shop {
    private Integer number;
    private Citys city;
    private String adress;
    private Integer phoneNumber;
}
