package system.crm.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
@Validated
public class AuthController {
    private final AuthService authService;
    private final UserService userService;

    private final UserMapper userMapper;

    @PostMapping("/sign-in")
    public JwtResponse login(final @Validated
                             @RequestBody JwtRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping("/sign-up")
    public UserDto register(final @Validated(OnCreate.class)
                            @RequestBody UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        User createdUser = userService.create(user);
        return userMapper.toDto(createdUser);
    }

    @PostMapping("/refresh")
    public JwtResponse refresh(final @RequestBody String refreshToken) {
        return authService.refresh(refreshToken);
    }
}
