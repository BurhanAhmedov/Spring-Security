package az.test.springsecurity.repository;

import az.test.springsecurity.model.Book;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends JpaRepository<Book, Long> {

  Optional<Book> findByActiveTrueAndId(long id);

  @Modifying
  @Query("update Book set active = false where id=:id")
  void softDeleteBookById(@Param("id") long id);


}
