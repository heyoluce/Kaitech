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

    private Long groupId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    @NotNull(message = "Gender is required", groups = {OnCreate.class, OnUpdate.class})
    private Gender gender;

    @NotNull(message = "Total debt is required", groups = {OnCreate.class, OnUpdate.class})
    @DecimalMin(value = "0.0", message = "Total debt must be greater than or equal to 0", groups = {OnCreate.class, OnUpdate.class})
    private BigDecimal totalDebt;

    @NotNull(message = "Total payment is required", groups = {OnCreate.class, OnUpdate.class})
    @DecimalMin(value = "0.0", message = "Total payment must be greater than or equal to 0", groups = {OnCreate.class, OnUpdate.class})
    private BigDecimal totalPayment;
}
