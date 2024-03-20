package system.crm.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import system.crm.web.dto.validation.OnCreate;
import system.crm.web.dto.validation.OnUpdate;



@Data
public class MentorDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    Long id;

    @NotBlank(message = "Full name is required", groups = {OnCreate.class, OnUpdate.class})
    @Schema(
            description = "Mentor name",
            example = "Amantur Zholdoshov"
    )
    private String name;

    @Email(message = "Invalid email address", groups = {OnCreate.class, OnUpdate.class})
    @Schema(
            description = "Mentor email",
            example = "azholdoshevv@gmail.com"
    )
    private String username;

    @NotBlank(message = "Phone number is required", groups = {OnCreate.class, OnUpdate.class})
    @Schema(
            description = "Mentor phone number",
            example = "+996771328181"
    )
    private String phoneNumber;

    private Long courseId;

    private String imageUrl;
}
