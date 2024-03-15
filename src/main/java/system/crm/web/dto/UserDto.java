package system.crm.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import system.crm.domain.enums.Role;
import system.crm.domain.enums.Status;
import system.crm.web.dto.validation.OnCreate;
import system.crm.web.dto.validation.OnUpdate;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Data
public class UserDto {

    private Long id;

    @NotNull(message = "First name must be not null", groups = {OnCreate.class, OnUpdate.class})
    @Length(max=255, message = "First name length must be smaller than 255 symbols", groups = {OnCreate.class, OnUpdate.class})
    private String firstName;

    @Length(max=255, message = "Last name length must be smaller than 255 symbols", groups = {OnCreate.class, OnUpdate.class})
    private String lastName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date_of_birth;

    @Pattern(regexp = "\\+996\\d{9}", message = "Invalid phone number format", groups = {OnUpdate.class, OnCreate.class} )
    private String phoneNumber;

    @Email(message = "Email must be valid", groups = {OnUpdate.class, OnCreate.class})
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "Password must be not null", groups = {OnCreate.class, OnUpdate.class})
    private String password;

    private Set<Role> roles;

    private boolean enabled;

    private String image_url;

    private Date last_visit_date;

    private Status status;

}
