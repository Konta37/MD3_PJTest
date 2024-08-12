package md3.projectmd3.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "sku")
    private UUID sku;

    @Column(name = "product_name")
    @NotBlank(message = "Product name can't be blank")
    private String productName;

    @Column(name = "description")
    private String description;

    @NotNull(message = "Unit price can't be empty")
    @Column(name = "unit_price")
    private Double unitPrice;

    @Column(name = "stock_quantity")
    @NotNull(message = "Stock can't be empty")
    private Integer stockQuantity;

    @Column(name = "image")
    @NotNull(message = "Image is required")
    private String image;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "cate_id")
    private Category category;

    @Column(name = "created")
    private Date created;

    @Column(name = "updated_at")
    private Date updatedAt;

    @ManyToMany
    @JoinTable(
            name = "wishlist",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<Users> users;
}
