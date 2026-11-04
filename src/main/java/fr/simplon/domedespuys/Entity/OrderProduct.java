package fr.simplon.domedespuys.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable= false)
    private Integer quantity;

    @Column(nullable= false)
    private Long price;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Purchase purchase;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Product product;


}
