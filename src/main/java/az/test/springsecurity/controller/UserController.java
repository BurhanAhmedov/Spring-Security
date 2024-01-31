package az.test.springsecurity.controller;

import az.test.springsecurity.request.UserRequest;
import az.test.springsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {


  private final UserService userService;

  @PostMapping
  public ResponseEntity<HttpStatus> insertUser(@RequestBody UserRequest request) {
    userService.addUser(request);
    return ResponseEntity.ok(HttpStatus.OK);
  }

}
