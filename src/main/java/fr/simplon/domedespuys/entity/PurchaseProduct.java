package fr.simplon.domedespuys.entity;

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
    private Long id;

    @Column(nullable= false)
    private int quantity;

    @Column(nullable= false)
    private int price;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Purchase purchase;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Product product;


}
