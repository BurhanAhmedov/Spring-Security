package az.test.springsecurity.config;

import az.test.springsecurity.model.User;
import az.test.springsecurity.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {

  @Autowired
  private UserRepository repository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    final Optional<User> userInfo = repository.findByName(username);
    return userInfo.map(UserInfoDetails::new)
        .orElseThrow(()->new UsernameNotFoundException("user not found"));
  }
}
