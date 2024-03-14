package system.crm.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import system.crm.domain.entity.Student;
import system.crm.service.StudentService;
import system.crm.web.dto.StudentDto;
import system.crm.web.dto.validation.OnCreate;
import system.crm.web.dto.validation.OnUpdate;
import system.crm.web.mappers.StudentMapper;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
@Validated
public class StudentController {

    private final StudentService studentService;
    private final StudentMapper studentMapper;

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable("id") Long id) {
        Student student = studentService.getById(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        StudentDto studentDto = studentMapper.toDto(student);
        return ResponseEntity.ok(studentDto);
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        List<Student> students = studentService.getAll();
        List<StudentDto> studentDtos = studentMapper.toDto(students);
        return ResponseEntity.ok(studentDtos);
    }

    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@Validated(OnCreate.class) @RequestBody StudentDto studentDto) {
        Student student = studentMapper.toEntity(studentDto);
        Student createdStudent = studentService.create(student);
        StudentDto createdStudentDto = studentMapper.toDto(createdStudent);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudentDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable("id") Long id, @Validated(OnUpdate.class) @RequestBody StudentDto studentDto) {
        Student existingStudent = studentService.getById(id);
        if (existingStudent == null) {
            return ResponseEntity.notFound().build();
        }
        studentDto.setId(id);
        Student updatedStudent = studentService.update(studentMapper.toEntity(studentDto));
        StudentDto updatedStudentDto = studentMapper.toDto(updatedStudent);
        return ResponseEntity.ok(updatedStudentDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("id") Long id) {
        Student existingStudent = studentService.getById(id);
        if (existingStudent == null) {
            return ResponseEntity.notFound().build();
        }
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
