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
    private Long id;

    @NotBlank(message = "Username is required", groups = {OnCreate.class, OnUpdate.class})
    private String username;

    @NotBlank(message = "First name is required", groups = {OnCreate.class, OnUpdate.class})
    private String firstName;

    @NotBlank(message = "Last name is required", groups = {OnCreate.class, OnUpdate.class})
    private String lastName;

    @Email(message = "Invalid email address", groups = {OnCreate.class, OnUpdate.class})
    private String email;

    @NotBlank(message = "Phone number is required", groups = {OnCreate.class, OnUpdate.class})
    private String phoneNumber;

    @NotNull(message = "Status is required", groups = {OnCreate.class, OnUpdate.class})
    private Status status;

    private Long courseId;

    private Integer salary;

    private String imageUrl;

}
