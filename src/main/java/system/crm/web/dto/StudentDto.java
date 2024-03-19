package system.crm.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import system.crm.web.dto.validation.OnCreate;
import system.crm.web.dto.validation.OnUpdate;

@Data
public class StudentDto {

    private Long id;

    @NotBlank(message = "First name is required", groups = {OnCreate.class, OnUpdate.class})
    private String name;

    @Email(message = "Invalid email address", groups = {OnCreate.class, OnUpdate.class})
    private String username;

    @NotBlank(message = "Phone number is required", groups = {OnCreate.class, OnUpdate.class})
    private String phoneNumber;

    private Long courseId;
}
