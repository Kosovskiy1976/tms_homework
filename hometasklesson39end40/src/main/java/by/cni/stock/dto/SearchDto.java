package by.cni.stock.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data @Getter
@AllArgsConstructor @NoArgsConstructor
public class SearchDto {
    private String search;
    private Integer price;
    private Integer quantity;
    private Boolean delivered;
}
