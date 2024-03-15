package system.crm.service;

import system.crm.domain.entity.Mentor;

import java.util.List;

public interface MentorService {
    List<Mentor> getAll();
    Mentor getById(Long id);

    Mentor getByEmail(String email);

    Mentor update(Mentor mentor);

    Mentor create(Mentor mentor);

    void delete(Long id);
}
