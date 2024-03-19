package system.crm.web.mappers;

import org.mapstruct.Mapper;
import system.crm.domain.entity.Course;
import system.crm.web.dto.CourseDto;
@Mapper(componentModel = "spring")
public interface CourseMapper extends Mappable<Course, CourseDto>{
}
