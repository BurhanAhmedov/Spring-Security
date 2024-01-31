package az.test.springsecurity.mapper;

import az.test.springsecurity.dto.BookDto;
import az.test.springsecurity.model.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {


  BookDto mapToDto(Book book);

}
