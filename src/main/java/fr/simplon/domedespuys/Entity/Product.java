package fr.simplon.domedespuys.Entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable= false)
    private String label;

    @Lob
    @Column()
    private String description;

    @Column(nullable= false)
    private Long price;

    @Column(nullable= false)
    private String slug;

    @Column(nullable= false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "product")
    List<Image> images;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Brand brand;

    @OneToMany(mappedBy = "product")
    List<OrderProduct> productOrder;
}
