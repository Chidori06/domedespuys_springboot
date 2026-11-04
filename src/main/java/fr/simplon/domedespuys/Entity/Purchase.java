package fr.simplon.domedespuys.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "purchase")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length= 20, unique= true, nullable= false)
    private String number;

    @Column(nullable = false)
    private EnumPurchaseStatus status = EnumPurchaseStatus.PENDING;

    @Column(nullable = false)
    private LocalDateTime createdAt;



}
