package system.crm.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import system.crm.domain.enums.Role;
import system.crm.domain.enums.Status;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name= "users")
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="date_of_birth")
    private LocalDate date_of_birth;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name = "role")
    @Enumerated(value = EnumType.STRING)
    private Set<Role> roles;

    @Column(name="enabled")
    private boolean enabled;

    @Column(name="image_url")
    private String image_url;

    @Column(name="last_visit_date")
    private Date last_visit_date;

    @Column(name="status")
    @Enumerated(value = EnumType.STRING)
    private Status status;
}
