package pl.coderslab.charity.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, unique = true)
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    @OneToMany(cascade = CascadeType.REMOVE)
    private List<Donation>donations;
    private int enabled;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name="user_role")
    private List<Role> roles;

    public void addDonation(Donation donation){
        donations.add(donation);
    }
}
