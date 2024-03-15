package system.crm.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.crm.domain.entity.Mentor;
import system.crm.domain.exception.ResourceNotFoundException;
import system.crm.repository.MentorRepository;
import system.crm.service.MentorService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MentorServiceImpl implements MentorService {
    private final MentorRepository mentorRepository;

    @Override
    public List<Mentor> getAll() {
        return mentorRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Mentor getById(Long id) {
        return mentorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mentor not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public Mentor getByEmail(String email) {
        // todo
        return mentorRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Mentor not found"));
    }

    @Override
    public Mentor update(Mentor mentor) {
        mentorRepository.save(mentor);
        return mentor;
    }

    @Override
    public Mentor create(Mentor mentor) {
        if (mentorRepository.findByEmail(mentor.getEmail()).isPresent()){
            throw new IllegalStateException("Mentor with this email already exists.");
        }
        mentorRepository.save(mentor);
        return mentor;
    }


    @Override
    public void delete(Long id) {
        mentorRepository.deleteById(id);
    }
}