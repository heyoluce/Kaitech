package system.crm.web.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import system.crm.domain.entity.User;
import system.crm.service.AuthService;
import system.crm.service.UserService;
import system.crm.web.dto.UserDto;
import system.crm.web.dto.auth.JwtRequest;
import system.crm.web.dto.auth.JwtResponse;
import system.crm.web.dto.validation.OnCreate;
import system.crm.web.mappers.UserMapper;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Tag(
        name = "Auth Controller",
        description = "Auth API"
)
@CrossOrigin
public class AuthController {

    private final AuthService authService;
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/login")
    @Operation(summary = "Sign in")
    public JwtResponse login(
            @Validated @RequestBody final JwtRequest loginRequest
    ) {
        return authService.login(loginRequest);
    }

    @PostMapping("/register")
    @Operation(summary = "Sign up")
    public UserDto register(
            @Validated(OnCreate.class)
            @RequestBody final UserDto userDto
    ) {
        User user = userMapper.toEntity(userDto);
        User createdUser = userService.create(user);
        return userMapper.toDto(createdUser);
    }

    @PostMapping("/refresh")
    @Operation(summary = "Refresh access token")
    public JwtResponse refresh(
            @RequestParam(name = "refreshToken") final String refreshToken
    ) {
        return authService.refresh(refreshToken);
    }

}
