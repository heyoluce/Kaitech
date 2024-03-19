package system.crm.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import system.crm.web.dto.validation.OnCreate;
import system.crm.web.dto.validation.OnUpdate;

@Data
public class CourseDto {
    @NotNull(message = "Course name must not be null", groups = {OnCreate.class, OnUpdate.class})
    private String courseName;
    @NotNull(message = "Course description must not be null", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Course description length must not exceed 255 symbols.")
    private String description;
    private String imageUrl;


}
