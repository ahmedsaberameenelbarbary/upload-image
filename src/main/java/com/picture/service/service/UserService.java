package com.picture.service.service;

import com.picture.service.dto.LoginDto;
import com.picture.service.dto.UserDto;
import org.apache.http.auth.InvalidCredentialsException;

public interface UserService {

    UserDto register(UserDto dto);
    String login(LoginDto loginDto) throws InvalidCredentialsException;

    String logEndMessage = "End :: {} :: method :: USER :{} :: Time: {}";
}
