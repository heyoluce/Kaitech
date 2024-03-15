package system.crm.service;

import system.crm.domain.entity.Student;

import java.util.List;

public interface StudentService {
    Student getById(Long id);

    List<Student> getAll();
    Student getByEmail(String email);

    Student update(Student student);

    Student create(Student student);

    void delete(Long id);
}
