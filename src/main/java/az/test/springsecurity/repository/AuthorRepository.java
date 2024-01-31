package az.test.springsecurity.repository;

import az.test.springsecurity.model.Author;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AuthorRepository extends JpaRepository<Author, Long> {
  
  List<Author> findByNameAndSurnameAndActiveTrue(String name,String surname);

  @Modifying
  @Query("update Author set active = false where id=:id")
  void softDeleteAuthorById(@Param("id") long id);
}
