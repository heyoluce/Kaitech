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
        List<Student> allStudents = studentRepository.findAll();
        if(allStudents.isEmpty()) throw new ResourceNotFoundException("Список студентов пуст.");
        else return allStudents;
    }

    @Override
    @Transactional(readOnly = true)
    public Student getByEmail(String email) {
        return studentRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
    }

    @Override
    public Student update(Student student) {
        studentRepository.save(student);
        return student;
    }

    @Override
    public Student create(Student student) {
        if (studentRepository.findByEmail(student.getEmail()).isPresent()) {
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
