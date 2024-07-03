package by.cni.stock.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;
@Getter @Setter
@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    @UuidGenerator
    private UUID id;
    private String name;
    private Integer price;
    private Integer quantity;
    @CreationTimestamp
    private LocalDateTime time;
    private String deleted;

}
