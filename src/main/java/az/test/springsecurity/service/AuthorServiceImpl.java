package az.test.springsecurity.service;

import az.test.springsecurity.dto.AuthorDto;
import az.test.springsecurity.exception.NoDataFoundException;
import az.test.springsecurity.mapper.AuthorMapper;
import az.test.springsecurity.model.Author;
import az.test.springsecurity.repository.AuthorRepository;
import az.test.springsecurity.request.AuthorRequest;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {

  private final AuthorRepository repository;
  private final AuthorMapper mapper;

  @Override
  public AuthorDto insertAuthor(AuthorRequest request) {
    final Author author = mapper.mapToAuthorFromRequest(request);
    repository.save(author);
    return mapper.mapToDtoFromAuthor(author);
  }

  @Override
  public AuthorDto findAuthorById(long id) {
    return repository
        .findById(id)
        .map(mapper::mapToDtoFromAuthor)
        .orElseThrow(() -> new NoDataFoundException("Author Not Found By Id: " + id));
  }

  public List<AuthorDto> findByNameAndSurname(String name, String surname) {
    final List<Author> authorList = repository.findByNameAndSurnameAndActiveTrue(name, surname);
    return authorList.stream()
        .map(mapper::mapToDtoFromAuthor)
        .collect(Collectors.toList());
  }

  @Override
  public List<AuthorDto> findAll() {
    final List<Author> authorList = repository.findAll();
    return authorList.stream()
        .map(mapper::mapToDtoFromAuthor)
        .collect(Collectors.toList());
  }

  @Override
  public AuthorDto updateAuthor(long id, AuthorRequest request) {
    return null;
  }

  @Override
  public void softDeleteAuthorById(long id) {

  }
}
