package system.crm.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import system.crm.domain.entity.Mentor;
import system.crm.service.MentorService;
import system.crm.web.dto.MentorDto;
import system.crm.web.dto.validation.OnCreate;
import system.crm.web.dto.validation.OnUpdate;
import system.crm.web.mappers.MentorMapper;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/mentor")
@Validated
public class MentorController {

    private final MentorService mentorService;
    private final MentorMapper mentorMapper;

    @GetMapping("/{id}")
    public ResponseEntity<MentorDto> getMentorById(@PathVariable("id") Long id) {
        Mentor mentor = mentorService.getById(id);
        if (mentor == null) {
            return ResponseEntity.notFound().build();
        }
        MentorDto mentorDto = mentorMapper.toDto(mentor);
        return ResponseEntity.ok(mentorDto);
    }

    @GetMapping
    public ResponseEntity<List<MentorDto>> getAllMentors() {
        List<Mentor> mentors = mentorService.getAll();
        List<MentorDto> mentorDtos = mentorMapper.toDto(mentors);
        return ResponseEntity.ok(mentorDtos);
    }

    @PostMapping
    public ResponseEntity<MentorDto> createMentor(@Validated(OnCreate.class) @RequestBody MentorDto mentorDto) {
        Mentor mentor = mentorMapper.toEntity(mentorDto);
        Mentor createdMentor = mentorService.create(mentor);
        MentorDto createdMentorDto = mentorMapper.toDto(createdMentor);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMentorDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MentorDto> updateMentor(@PathVariable("id") Long id, @Validated(OnUpdate.class) @RequestBody MentorDto mentorDto) {
        Mentor existingMentor = mentorService.getById(id);
        if (existingMentor == null) {
            return ResponseEntity.notFound().build();
        }
        mentorDto.setId(id);
        Mentor updatedMentor = mentorService.update(mentorMapper.toEntity(mentorDto));
        MentorDto updatedMentorDto = mentorMapper.toDto(updatedMentor);
        return ResponseEntity.ok(updatedMentorDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMentor(@PathVariable("id") Long id) {
        Mentor existingMentor = mentorService.getById(id);
        if (existingMentor == null) {
            return ResponseEntity.notFound().build();
        }
        mentorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
