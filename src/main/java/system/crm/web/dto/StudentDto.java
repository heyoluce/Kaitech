package system.crm.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import system.crm.domain.enums.Gender;
import system.crm.domain.enums.Status;
import system.crm.web.dto.validation.OnCreate;
import system.crm.web.dto.validation.OnUpdate;


import java.math.BigDecimal;
import java.util.Date;

@Data
public class StudentDto {

    private Long id;

    @NotBlank(message = "First name is required", groups = {OnCreate.class, OnUpdate.class})
    private String fullName;

    @Email(message = "Invalid email address", groups = {OnCreate.class, OnUpdate.class})
    private String email;

    @NotBlank(message = "Phone number is required", groups = {OnCreate.class, OnUpdate.class})
    private String phoneNumber;

    private Long courseId;
}
