package model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;

    @Column(unique = true)
    private String name;

    private long quantity;

    private double unitPrice;
}
