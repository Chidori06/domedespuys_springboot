package fr.simplon.domedespuys.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable= false)
    private String line;

    @Column
    private String extraLine;

    @Column(nullable= false)
    private String city;

    @Column(nullable= false)
    private String zipCode;

    @Column(nullable= false)
    private String country;

    @Column
    private String phone;

    @Column(nullable= false)
    private String firstname;

    @Column(nullable= false)
    private String lastname;

    @Column(nullable= false)
    private LocalDateTime createdAt;
}
