package system.crm.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import system.crm.domain.enums.Status;

import java.io.Serializable;

@Entity
@Table(name="mentors")
@Data
public class Mentor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="username")
    private String username;

    @Column(name="name")
    private String name;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name = "salary")
    private Integer salary;

    @Column(name="status")
    @Enumerated(value = EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name="course_id", referencedColumnName = "id")
    private Course course;

    @Column(name="image_url")
    private String imageUrl;

}
