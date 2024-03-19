package system.crm.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;
import system.crm.domain.enums.CourseName;
import system.crm.domain.enums.Status;

import java.util.Objects;

@Entity
@Table(name="courses")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="course_name")
    @Enumerated(value = EnumType.STRING)
    private CourseName courseName;

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

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Course course = (Course) o;
        return getId() != null && Objects.equals(getId(), course.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
