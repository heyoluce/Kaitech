package system.crm.service;

import system.crm.domain.entity.Student;
import system.crm.web.dto.StudentDto;

import java.util.List;

public interface StudentService {
    Student getById(Long id);

    List<Student> getAll();
    StudentDto update(String email, StudentDto studentDto);
    Student getByEmail(String email);
    StudentDto create(StudentDto studentDto);

    void delete(String email);
}
