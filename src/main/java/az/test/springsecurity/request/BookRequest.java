package az.test.springsecurity.request;

import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookRequest {

  String name;
  int pageCount;
  int price;
  int stock;
  boolean active;
  LocalDate createDate;

}
