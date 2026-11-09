package fr.simplon.domedespuys.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.view.PurchaseProductView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class PurchaseProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(PurchaseProductView.Id.class)
    private Long id;

    @Column(nullable= false)
    @JsonView(PurchaseProductView.Quantity.class)
    private int quantity;

    @Column(nullable= false)
    @JsonView(PurchaseProductView.Price.class)
    private int price;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    @JsonView(PurchaseProductView.Purchases.class)
    private Purchase purchase;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    @JsonView(PurchaseProductView.Products.class)
    private Product product;


}
