package system.crm.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import system.crm.domain.entity.Student;
import system.crm.domain.exception.ResourceNotFoundException;
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
@Tag(
        name = "Student Controller",
        description = "Student API"
)
public class StudentController {

    private final StudentService studentService;
    private final StudentMapper studentMapper;

    @GetMapping("/{id}")
    @Operation(summary = "Get student by ID")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable("id") Long id) {
        Student student = studentService.getById(id);
        return ResponseEntity.ok(studentMapper.toDto(student));
    }

    @GetMapping
    @Operation(summary = "Get all students")
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        List<Student> students = studentService.getAll();
        List<StudentDto> studentDtos = studentMapper.toDto(students);
        return ResponseEntity.ok(studentDtos);
    }

    @PostMapping
    @Operation(summary = "Create a student")
    public ResponseEntity<StudentDto> createStudent(@Validated(OnCreate.class) @RequestBody StudentDto studentDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.create(studentDto));
    }

    @PatchMapping("/update")
    @Operation(summary = "Update info about student")
    public ResponseEntity<StudentDto> updateStudent(@RequestParam(name = "email") String email, @Validated(OnUpdate.class) @RequestBody StudentDto studentDto) throws ResourceNotFoundException {
        return ResponseEntity.ok(studentService.update(email, studentDto));
    }

    @DeleteMapping("delete")
    @Operation(summary = "Delete student by email")
    public ResponseEntity<Void> deleteStudent(@RequestParam String email) {
        Student existingStudent = studentService.getByEmail(email);
        if (existingStudent == null) {
            return ResponseEntity.notFound().build();
        }
        studentService.delete(email);
        return ResponseEntity.noContent().build();
    }
}
