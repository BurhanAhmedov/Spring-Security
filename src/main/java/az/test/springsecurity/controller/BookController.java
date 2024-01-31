package az.test.springsecurity.controller;

import az.test.springsecurity.dto.BookDto;
import az.test.springsecurity.model.Book;
import az.test.springsecurity.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

  private final BookService bookService;

  @PostMapping()
  public ResponseEntity<Book> insertBook(@RequestBody Book book) {
    Book response = bookService.insertBook(book);
    return ResponseEntity.ok(response);
  }

  @GetMapping("{id}")
  public ResponseEntity<BookDto> getBookById(@PathVariable long id) {
    final BookDto bookById = bookService.getBookById(id);
    return ResponseEntity.ok(bookById);
  }

  @GetMapping("/index")
  public ResponseEntity<String> getIndex() {
    return ResponseEntity.ok("Success");
  }

  @PutMapping("/delete/{id}")
  public ResponseEntity<HttpStatus> deleteBookById(@PathVariable long id) {
    bookService.deleteBookById(id);
    return ResponseEntity.ok(HttpStatus.OK);
  }

}
