package system.crm.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import system.crm.domain.enums.PaymentType;

import java.time.LocalDate;

@Entity
@Table(name="payment")
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="student_id", referencedColumnName = "id")
    private Student student;

    @Column(name="sum")
    private Integer sum;

    @Column(name="date")
    private LocalDate date;

    @Column(name="payment_type")
    private PaymentType paymentType;
}
