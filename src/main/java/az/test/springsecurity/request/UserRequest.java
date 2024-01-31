package az.test.springsecurity.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRequest {
  private Long id;

  private String name;
  private String surname;
  private String mail;
  private String password;
  private String role;
}
