package az.test.springsecurity.controller;

import az.test.springsecurity.dto.AuthorDto;
import az.test.springsecurity.request.AuthorRequest;
import az.test.springsecurity.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {

  private final AuthorService service;

  @PostMapping()
  public ResponseEntity<AuthorDto> insertBook(@RequestBody AuthorRequest request) {
    AuthorDto response = service.insertAuthor(request);
    return ResponseEntity.ok(response);
  }

  @GetMapping("{id}")
  public ResponseEntity<AuthorDto> getAuthorById(@PathVariable long id) {
    final AuthorDto author = service.findAuthorById(id);
    return ResponseEntity.ok(author);
  }

}
