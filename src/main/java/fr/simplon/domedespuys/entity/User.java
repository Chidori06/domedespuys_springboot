package fr.simplon.domedespuys.entity;

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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable= false, length = 120)
    private String email;

    @Column(nullable= false)
    private String password;

    @Column(nullable= false, length = 80)
    private String firstname;

    @Column(nullable= false, length = 80)
    private String lastname;

    @Column(length = 20)
    private String phone;

    @Column(nullable= false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "user")
   private List<Address> addresses;

    @OneToMany(mappedBy = "user")
    private List<Purchase> purchases;

}
