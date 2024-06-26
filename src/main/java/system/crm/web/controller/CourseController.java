package system.crm.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import system.crm.domain.entity.Course;
import system.crm.service.CourseService;
import system.crm.web.dto.CourseDto;
import system.crm.web.dto.validation.OnCreate;
import system.crm.web.mappers.CourseMapper;

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
    private final CourseMapper courseMapper;
    @PostMapping
    @Operation(summary = "Create a course")
    public ResponseEntity<CourseDto> create(@Validated(OnCreate.class)
                                                @RequestBody CourseDto courseDto){
        Course course = courseMapper.toEntity(courseDto);
        courseService.create(course);
        return ResponseEntity.ok(courseDto);
    }

    @GetMapping
    @Operation(summary = "Get all courses")
    public ResponseEntity<List<CourseDto>> getAll(){
        List<CourseDto> courseDto = courseMapper.toDto(courseService.getAllCourses());
        return ResponseEntity.ok(courseDto);
    }
}
