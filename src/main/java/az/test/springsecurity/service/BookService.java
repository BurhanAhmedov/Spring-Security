package az.test.springsecurity.service;

import az.test.springsecurity.dto.BookDto;
import az.test.springsecurity.model.Book;

public interface BookService {
  Book insertBook(Book book);

  BookDto getBookById(long id);


  void deleteBookById(long id);
}
