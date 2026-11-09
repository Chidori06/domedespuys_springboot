package fr.simplon.domedespuys.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.view.BrandView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(BrandView.Id.class)
    private Long id;

    @Column(nullable = false)
    @JsonView(BrandView.Label.class)
    private String label;

    @Column(columnDefinition = "TEXT")
    @JsonView(BrandView.Logo.class)
    private String logo;

    @Column(nullable = false)
    @JsonView(BrandView.Slug.class)
    private String slug;

    @OneToMany(mappedBy = "brand")
    @JsonView(BrandView.Products.class)
    private List<Product> products = new ArrayList<>();

}
