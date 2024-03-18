package system.crm.web.dto;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import system.crm.web.dto.validation.OnCreate;
import system.crm.web.dto.validation.OnUpdate;

public class CourseDto {
    @NotNull(message = "Course name must not be null", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Course name length must not exceed 255 symbols.")
    private String courseName;
    @NotNull(message = "Course name must not be null", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Course description length must not exceed 255 symbols.")
    private String description;
    private String imageUrl;


}
