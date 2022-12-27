package com.picture.service.controller;


import com.picture.service.dto.LoginDto;
import com.picture.service.dto.UserDto;
import com.picture.service.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.apache.http.auth.InvalidCredentialsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 *
 * @author ahmedSaber
 *
 */

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Tag(name = "USER-CONTROLLER")
public class UserController {

    private final UserService service;

    @Operation(summary = "register" ,description = "do registration ")
    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@Valid @RequestBody UserDto userDto) {

        return  ResponseEntity.ok().body( service.register(userDto));
    }

    @Operation(summary = "login" ,description = "do login ")
    @PostMapping("/login")
    public ResponseEntity<String> userLogin(@RequestBody LoginDto loginDto) throws InvalidCredentialsException {

        return  ResponseEntity.ok().body( service.login(loginDto));
    }
}
