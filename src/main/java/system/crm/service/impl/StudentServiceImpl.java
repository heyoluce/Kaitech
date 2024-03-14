package system.crm.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.crm.domain.entity.Mentor;
import system.crm.domain.entity.Student;
import system.crm.domain.exception.ResourceNotFoundException;
import system.crm.repository.MentorRepository;
import system.crm.repository.StudentRepository;
import system.crm.service.MentorService;
import system.crm.service.StudentService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    @Transactional(readOnly = true)
    public Student getById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Student getByUsername(String username) {
        return studentRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
    }

    @Override
    public Student update(Student student) {
        studentRepository.save(student);
        return student;
    }

    @Override
    public Student create(Student student) {
        if (studentRepository.findByUsername(student.getUsername()).isPresent()) {
            throw new IllegalStateException("Student already exists.");
        }
        studentRepository.save(student);
        return student;
    }


    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}
