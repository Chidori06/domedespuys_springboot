package fr.simplon.domedespuys.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.view.UserView;
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
    @JsonView(UserView.Id.class)
    private Long id;

    @Column(nullable= false, length = 120)
    @JsonView(UserView.Email.class)
    private String email;

    @Column(nullable= false)
    private String password;

    @Column(nullable= false, length = 80)
    @JsonView(UserView.Firstname.class)
    private String firstname;

    @Column(nullable= false, length = 80)
    @JsonView(UserView.Lastname.class)
    private String lastname;

    @Column(length = 20)
    @JsonView(UserView.Phone.class)
    private String phone;

    @Column(nullable= false)
    @JsonView(UserView.CreatedAt.class)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "user")
    @JsonView(UserView.Address.class)
   private List<Address> addresses;

    @OneToMany(mappedBy = "user")
    @JsonView(UserView.Purchase.class)
    private List<Purchase> purchases;

}
