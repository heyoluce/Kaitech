package system.crm.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import system.crm.service.CourseService;
import system.crm.web.dto.CourseDto;
import system.crm.web.dto.validation.OnCreate;

import java.util.List;

@RestController
@RequestMapping("api/v1/courses")
@Tag(
        name = "Course Controller",
        description = "Course API"
)
@Validated
@Data
@AllArgsConstructor
public class CourseController {
    private final CourseService courseService;
    @PostMapping
    @Operation(summary = "Create a course")
    public ResponseEntity<CourseDto> create(@Validated(OnCreate.class) @RequestBody CourseDto courseDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.create(courseDto));
    }

    @GetMapping
    @Operation(summary = "Get all courses")
    public ResponseEntity<List<CourseDto>> getAll(){
        return ResponseEntity.ok(courseService.getAllCourses());
    }
}
