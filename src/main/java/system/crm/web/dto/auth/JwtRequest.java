package system.crm.web.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class JwtRequest {
    @NotNull(message = "Username must be not null")
    private String username;

    @NotNull(message = "Password must be not null")
    private String password;
}
