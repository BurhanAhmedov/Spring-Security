package az.test.springsecurity.mapper;


import az.test.springsecurity.model.Author;
import az.test.springsecurity.request.AuthorRequest;
import az.test.springsecurity.dto.AuthorDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE )
public interface AuthorMapper {
  AuthorDto mapToDtoFromAuthor(Author author);

  Author mapToAuthorFromRequest(AuthorRequest request);

  @Mapping(target = "id",ignore = true)
  @Mapping(target = "active",ignore = true)
  Author mapForUpdate(@MappingTarget Author author, AuthorRequest request);
}
