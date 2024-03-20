package system.crm.web.mappers;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import system.crm.domain.entity.User;
import system.crm.web.dto.UserDto;

@Mapper(componentModel = "spring")
// roma pedik
public interface UserMapper extends Mappable <User, UserDto> {
}
