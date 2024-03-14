package system.crm.web.mappers;

import org.mapstruct.Mapper;
import system.crm.domain.entity.Student;
import system.crm.web.dto.StudentDto;

@Mapper(componentModel = "spring")
public interface StudentMapper extends Mappable<Student, StudentDto> {
}
