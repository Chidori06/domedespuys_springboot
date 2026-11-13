package fr.simplon.domedespuys.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.view.ProductView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(ProductView.Id.class)
    private Long id;

    @Column(nullable= false)
    @JsonView(ProductView.Label.class)
    private String label;

    @Column(columnDefinition = "TEXT")
    @JsonView(ProductView.Description.class)
    private String description;

    @Column(nullable= false)
    @JsonView(ProductView.Price.class)
    private int price;

    @Column(nullable= false)
    @JsonView(ProductView.Slug.class)
    private String slug;

    @Column(nullable= false)
    @JsonView(ProductView.CreatedAt.class)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "product")
    @JsonView(ProductView.Images.class)
    private List<Image> images = new ArrayList<>();

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    @JsonView(ProductView.Brand.class)
    private Brand brand;

}
