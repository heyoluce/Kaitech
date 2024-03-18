package system.crm.service;

import system.crm.domain.entity.Student;

import java.util.List;

public interface StudentService {
    Student getById(Long id);

    List<Student> getAll();
    Student getByUsername(String username);

    Student update(Student student);

    Student create(Student student);

    void delete(Long id);
}
