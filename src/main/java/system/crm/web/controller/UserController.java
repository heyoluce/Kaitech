package system.crm.web.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import system.crm.domain.entity.User;
import system.crm.service.UserService;
import system.crm.web.dto.UserDto;
import system.crm.web.dto.validation.OnUpdate;
import system.crm.web.mappers.UserMapper;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Validated
@Tag(
        name = "User Controller",
        description = "User API"
)
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PutMapping
    @Operation(summary = "Update user")
    public UserDto update(
            @Validated(OnUpdate.class)
            @RequestBody final UserDto dto
    ) {
        User user = userMapper.toEntity(dto);
        User updatedUser = userService.update(user);
        return userMapper.toDto(updatedUser);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get UserDto by id")
    public UserDto getById(
            @PathVariable  final Long id
    ) {
        User user = userService.getById(id);
        return userMapper.toDto(user);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete user by id")
    public void deleteById(
            @PathVariable final Long id
    ) {
        userService.delete(id);
    }


}
