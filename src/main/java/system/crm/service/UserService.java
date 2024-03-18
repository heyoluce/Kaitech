package system.crm.service;

import system.crm.domain.entity.User;

public interface UserService {
    User getById(Long id);

    User getByUsername(String username);

    User update(User user);

    User create(User user);

    void delete(Long id);
}
