package az.test.springsecurity.mapper;

import az.test.springsecurity.model.User;
import az.test.springsecurity.request.UserRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

  User mapToUserFromRequest(UserRequest request);


}
