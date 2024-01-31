package az.test.springsecurity.service;

import az.test.springsecurity.mapper.UserMapper;
import az.test.springsecurity.model.User;
import az.test.springsecurity.repository.UserRepository;
import az.test.springsecurity.request.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserRepository repository;
  private final UserMapper mapper;
  private final PasswordEncoder encoder;

  @Override
  public void addUser(UserRequest request) {
    final User user = mapper.mapToUserFromRequest(request);
    user.setPassword(encoder.encode(user.getPassword()));
    repository.save(user);
  }
}
