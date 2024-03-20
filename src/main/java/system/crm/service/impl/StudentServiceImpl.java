package system.crm.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.crm.domain.entity.Student;
import system.crm.domain.exception.ResourceNotFoundException;
import system.crm.repository.StudentRepository;
import system.crm.service.StudentService;
import system.crm.web.dto.StudentDto;
import system.crm.web.mappers.StudentMapper;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    @Transactional(readOnly = true)
    public Student getById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student with id " + id + " was not found."));
    }


    @Override
    public Student getByEmail(String email) {
        return studentRepository
                .findByUsername(email)
                .orElseThrow(() -> new ResourceNotFoundException("Student with email " + email + " was not found."));
    }


    @Override
    public List<Student> getAll() {
        List<Student> allStudents = studentRepository.findAll();
        if(allStudents.isEmpty()) throw new ResourceNotFoundException("List of students is empty.");
        else return allStudents;
    }

    @Override
    public StudentDto update(String email, StudentDto studentDto) {
        Optional<Student> existingStudent = studentRepository
                .findByUsername(email);
        if(existingStudent.isPresent()){
            Student foundStudent = existingStudent.get();
            foundStudent.setName(studentDto.getName());
            foundStudent.setUsername(studentDto.getUsername());
            foundStudent.setPhoneNumber(studentDto.getPhoneNumber());
            studentRepository.save(foundStudent);

            return studentMapper.toDto(foundStudent);
        }else {
            throw new ResourceNotFoundException("User with email " + email + " was not found");
        }
    }

    @Override
    public StudentDto create(StudentDto studentDto) {
        if (studentRepository.findByUsername(studentDto.getUsername()).isPresent()) {
            throw new IllegalStateException("Student with this email already exists.");
        } else{
            Student createdStudent = studentMapper.toEntity(studentDto);
            studentRepository.save(createdStudent);
            return studentMapper.toDto(createdStudent);

        }
    }


    @Override
    public void delete(String email) {
        studentRepository.deleteByUsername(email);
    }
}
