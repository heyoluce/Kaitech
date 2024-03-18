package system.crm.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import system.crm.web.dto.validation.OnCreate;
import system.crm.web.dto.validation.OnUpdate;

import java.util.Date;

@Data
public class UserDto {

    @NotNull(message = "name must be not null", groups = {OnCreate.class, OnUpdate.class})
    @Length(max=255, message = "name length must be smaller than 255 symbols", groups = {OnCreate.class, OnUpdate.class})
    private String name;

    @NotNull(message = "Date of birth must not be null", groups = {OnCreate.class, OnUpdate.class})
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    @NotNull(message = "Phone number must not be null", groups = {OnCreate.class, OnUpdate.class})
    @Pattern(regexp = "\\+996\\d{9}", message = "Invalid phone number format", groups = {OnUpdate.class, OnCreate.class} )
    private String phoneNumber;

    @NotNull(message = "Email must not be null", groups = {OnCreate.class, OnUpdate.class})
    @Email(message = "Email must be valid", groups = {OnUpdate.class, OnCreate.class})
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "Password must be not null", groups = {OnCreate.class, OnUpdate.class})
    private String password;
}
