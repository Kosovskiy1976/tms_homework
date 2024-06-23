package by.cni;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor @Getter
@Setter
//@ToString
@Entity
@Table(name = "persons")
public class PersonEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer age;
    private String surname;
    @CreationTimestamp
    private Date createDate;
    @UpdateTimestamp
    private Date upDate;
    @Version
    private Integer versionRecord;
    @OneToMany(mappedBy = "person", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<OrderEntity> orderEntities;



}
