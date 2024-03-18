package system.crm.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import system.crm.domain.entity.Course;
import system.crm.domain.enums.Status;
import system.crm.web.dto.validation.OnCreate;
import system.crm.web.dto.validation.OnUpdate;

;

@Data
public class MentorDto {
    @NotBlank(message = "Full name is required", groups = {OnCreate.class, OnUpdate.class})
    private String fullName;

    @Email(message = "Invalid email address", groups = {OnCreate.class, OnUpdate.class})
    private String email;

    @NotBlank(message = "Phone number is required", groups = {OnCreate.class, OnUpdate.class})
    private String phoneNumber;

    private Long courseId;

    private String imageUrl;

}
