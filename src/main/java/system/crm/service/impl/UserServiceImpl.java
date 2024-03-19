package system.crm.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.crm.domain.entity.User;
import system.crm.domain.enums.Role;
import system.crm.domain.exception.ResourceNotFoundException;
import system.crm.repository.UserRepository;
import system.crm.service.UserService;

import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;


    @Override
    @Transactional(readOnly = true)
    public User getById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        System.out.println(user.getUsername());
        return user;
    }

    @Override
    @Transactional(readOnly = true)
    public User getByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public User update(User user) {
        User existing = getById(user.getId());
        existing.setName(user.getName());
        user.setUsername(user.getUsername());
        user.setPassword(user.getPassword());
        userRepository.save(user);
        return user;
    }


    @Override
    public User create(User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new IllegalStateException("User already exists.");
        }
        user.setPassword(user.getPassword());
        Set<Role> roles = Set.of(Role.ROLE_USER);
        user.setRoles(roles);
        userRepository.save(user);
        return user;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
