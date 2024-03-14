package system.crm.web.mappers;

import org.mapstruct.Mapper;
import system.crm.domain.entity.Mentor;
import system.crm.domain.entity.Student;
import system.crm.web.dto.MentorDto;
import system.crm.web.dto.StudentDto;

@Mapper(componentModel = "spring")
public interface MentorMapper extends Mappable<Mentor, MentorDto> {
}
