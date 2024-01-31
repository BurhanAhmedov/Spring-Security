package az.test.springsecurity.service;


import az.test.springsecurity.dto.BookDto;
import az.test.springsecurity.exception.NoDataFoundException;
import az.test.springsecurity.mapper.BookMapper;
import az.test.springsecurity.model.Author;
import az.test.springsecurity.model.Book;
import az.test.springsecurity.repository.BookRepository;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

  private final BookRepository bookRepository;
  private final BookMapper bookMapper;


  @Override
  public Book insertBook(Book book) {
    Book savedBook = bookRepository.save(book);
    log.info("Book insert success!");
    return savedBook;
  }

  @Override
  public BookDto getBookById(long id) {
    final BookDto bookDto = bookRepository.findByActiveTrueAndId(id)
        .map(bookMapper::mapToDto)
        .orElseThrow(() -> new NoDataFoundException("Book Not Found By Id:" + id));
    return bookDto;
  }

  @Transactional
  @Override
  public void deleteBookById(long id) {
    bookRepository.softDeleteBookById(id);

  }


}
