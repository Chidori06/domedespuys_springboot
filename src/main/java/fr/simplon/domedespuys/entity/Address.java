package fr.simplon.domedespuys.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.view.AddressView;
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
    @JsonView(AddressView.Id.class)
    private Long id;

    @Column(nullable= false)
    @JsonView(AddressView.Line.class)
    private String line;

    @Column
    @JsonView(AddressView.ExtraLine.class)
    private String extraLine;

    @Column(nullable= false)
    @JsonView(AddressView.City.class)
    private String city;

    @Column(nullable= false)
    @JsonView(AddressView.ZipCode.class)
    private String zipCode;

    @Column(nullable= false)
    @JsonView(AddressView.Country.class)
    private String country;

    @Column
    @JsonView(AddressView.Phone.class)
    private String phone;

    @Column(nullable= false)
    @JsonView(AddressView.Firstname.class)
    private String firstname;

    @Column(nullable= false)
    @JsonView(AddressView.Lastname.class)
    private String lastname;

    @Column(nullable= false)
    @JsonView(AddressView.CreatedAt.class)
    private LocalDateTime createdAt;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    @JsonView(AddressView.User.class)
    private User user;

}
