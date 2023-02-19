package com.samsung.premasterclassspringsecurity.rest.controller;

import com.samsung.premasterclassspringsecurity.exception.UserAlreadyExistsException;
import com.samsung.premasterclassspringsecurity.rest.dto.UserDto;
import com.samsung.premasterclassspringsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @GetMapping("/user/{email}")
    public UserDto findUserByEmail(@PathVariable("email") String email){
        return UserDto.toDto(userService.findByEmail(email));
    }
    @PostMapping("/user")
    public UserDto insertUser(@RequestBody UserDto userDto){
        return UserDto.toDto(userService.save(UserDto.fromDto(userDto)));
    }
    @ExceptionHandler({UserAlreadyExistsException.class, UsernameNotFoundException.class})
    public ResponseEntity<String> handlerUserException(Exception e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
