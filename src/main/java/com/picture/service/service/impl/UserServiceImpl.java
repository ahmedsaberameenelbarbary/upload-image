package com.picture.service.service.impl;

import com.picture.service.dto.AuthResponseDTO;
import com.picture.service.dto.LoginDto;
import com.picture.service.dto.UserDto;
import com.picture.service.entity.UserEntity;
import com.picture.service.exception.cust.exeption.RegistrationException;
import com.picture.service.mapper.UserMapper;
import com.picture.service.repository.UserRepository;
import com.picture.service.service.UserService;
import com.picture.service.service.util.SessionData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.auth.InvalidCredentialsException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper mapper;

    private final SessionData sessionData;



    public UserDto register(UserDto dto) {

        Long start = System.currentTimeMillis();

        String methodName = "register";

        try {

            UserDto user =  mapper.map(userRepository.save(mapper.unMap(dto)));

            log.info(logEndMessage, methodName,dto.getUsername(), System.currentTimeMillis() - start);

            return user;

        }  catch (Exception exception) {

        throw new RegistrationException();
    }

    }

    public String login(LoginDto loginDto) throws InvalidCredentialsException {

        Long start = System.currentTimeMillis();

        String methodName = "login";

        Optional<UserEntity> loginUser = userRepository.findByUsernameLikeOrEmailLikeAndPassword(loginDto.getUsername(),loginDto.getUsername(), loginDto.getPassword());

        if (loginUser.isPresent()) {
            sessionData.setAuthResponseDTO(new AuthResponseDTO(loginUser.get().getUsername())) ;

            log.info(logEndMessage, methodName,loginDto.getUsername(), System.currentTimeMillis() - start);

            return " logged in successfully";
        }

        throw new InvalidCredentialsException( "invalid credential");

    }
}
