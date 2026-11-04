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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable= false, length= 120)
    private String email;

    @Column(nullable= false)
    private String password;

    @Column(nullable= false)
    private String firstname;

    @Column(nullable= false)
    private String lastname;

    @Column
    private String phone;

    @Column(nullable= false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "user")
   List<Address> addresses;

    @OneToMany(mappedBy = "user")
    List<Purchase> purchases;

}
