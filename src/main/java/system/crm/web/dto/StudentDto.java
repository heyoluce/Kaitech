package system.crm.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import system.crm.web.dto.validation.OnCreate;
import system.crm.web.dto.validation.OnUpdate;

import java.time.LocalDateTime;

@Data
public class StudentDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    Long id;

    @NotBlank(message = "Name is required", groups = {OnCreate.class, OnUpdate.class})
    @Schema(
            description = "Student name",
            example = "Amantur Zholdoshov"
    )
    private String name;

    @Email(message = "Invalid email address", groups = {OnCreate.class, OnUpdate.class})
    @NotBlank(message = "Email is required", groups = {OnCreate.class, OnUpdate.class})
    @Schema(
            description = "Student email",
            example = "azholdoshevv@gmail.com"
    )
    private String username;

    @NotBlank(message = "Phone number is required", groups = {OnCreate.class, OnUpdate.class})
    @Pattern(regexp = "\\+996\\d{9}", message = "Invalid phone number format", groups = {OnUpdate.class, OnCreate.class} )
    @Schema(
            description = "Student phone number",
            example = "+996771328181"
    )
    private String phoneNumber;

    private Long courseId;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime created_at;
}
