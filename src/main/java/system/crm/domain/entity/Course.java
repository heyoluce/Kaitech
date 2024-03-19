package system.crm.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import system.crm.domain.enums.CourseField;
import system.crm.domain.enums.Status;

@Entity
@Table(name="courses")
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="course_name")
    @Enumerated(value = EnumType.STRING)
    private CourseField courseName;

    @Column(name="cost")
    private Integer cost;

    @Column(name="duration_in_months")
    private Integer durationInMonths;

    @Column(name="description")
    private String description;

    @Column(name="image_url")
    private String imageUrl;

    @Column(name="status")
    @Enumerated(value = EnumType.STRING)
    private Status status;

    @Column(name="number_of_lessons")
    private Integer numberOfLessons;
}
