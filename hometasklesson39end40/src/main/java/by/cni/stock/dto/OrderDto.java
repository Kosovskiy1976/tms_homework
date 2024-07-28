package by.cni.stock.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor @NoArgsConstructor
public class OrderDto {
    private UUID id;
    private String name;
    private Integer price;
    private Integer quantity;
    private String deleted;
    private Boolean delivered;
}
