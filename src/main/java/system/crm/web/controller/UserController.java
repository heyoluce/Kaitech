package system.crm.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import system.crm.domain.entity.User;
import system.crm.service.UserService;
import system.crm.web.dto.UserDto;
import system.crm.web.dto.validation.OnUpdate;
import system.crm.web.mappers.UserMapper;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
@Validated
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PutMapping
    public ResponseEntity<UserDto> update(@Validated(OnUpdate.class)
                          @RequestBody UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        User updatedUser = userService.update(user);
        return ResponseEntity.ok(userMapper.toDto(updatedUser));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable Long id) {
        User user = userService.getById(id);
        return ResponseEntity.ok(userMapper.toDto(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }
}
