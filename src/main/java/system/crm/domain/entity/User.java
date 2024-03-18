package system.crm.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import system.crm.domain.enums.Role;
import system.crm.domain.enums.Status;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name= "users")
@Getter
@Setter
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="date_of_birth")
    private Date date_of_birth;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name = "role")
    @Enumerated(value = EnumType.STRING)
    private Set<Role> roles;

    @Column(name="enabled")
    private boolean enabled;

    @Column(name="image_url")
    private String imageUrl;

    @Column(name="last_visit_date")
    private Date lastVisitDate;

    @Column(name="status")
    @Enumerated(value = EnumType.STRING)
    private Status status;
}
