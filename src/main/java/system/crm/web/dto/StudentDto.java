package system.crm.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import system.crm.web.dto.validation.OnCreate;
import system.crm.web.dto.validation.OnUpdate;

@Data
public class StudentDto {

    @NotBlank(message = "Full name is required", groups = {OnCreate.class, OnUpdate.class})
    private String fullName;

    @Email(message = "Invalid email address", groups = {OnCreate.class, OnUpdate.class})
    @NotBlank(message = "Email is required", groups = {OnCreate.class, OnUpdate.class})
    private String username;

    @NotBlank(message = "Phone number is required", groups = {OnCreate.class, OnUpdate.class})
    @Pattern(regexp = "\\+996\\d{9}", message = "Invalid phone number format", groups = {OnUpdate.class, OnCreate.class} )
    private String phoneNumber;

    private Long courseId;
}
