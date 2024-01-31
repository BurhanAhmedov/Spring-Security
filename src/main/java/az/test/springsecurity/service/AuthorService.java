package az.test.springsecurity.service;

import az.test.springsecurity.dto.AuthorDto;
import az.test.springsecurity.request.AuthorRequest;
import java.util.List;

public interface AuthorService {

  AuthorDto insertAuthor(AuthorRequest request);

  AuthorDto findAuthorById(long id);

  List<AuthorDto> findByNameAndSurname(String name,String surname);

  List<AuthorDto> findAll();

  AuthorDto updateAuthor(long id, AuthorRequest request);

  void softDeleteAuthorById(long id);
}
