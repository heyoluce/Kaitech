package system.crm.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import system.crm.domain.enums.Gender;
import system.crm.domain.enums.Status;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="students")
@Data
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="status")
    @Enumerated(value = EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Group group;

    @Column(name="date_of_birth")
    private Date dateOfBirth;

    @Column(name="gender")
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Column(name="total_debt")
    private BigDecimal totalDebt;

    @Column(name="total_payment")
    private BigDecimal totalPayment;

}
