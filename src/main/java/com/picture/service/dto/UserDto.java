package com.picture.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private int id;
    private String email;
    private String password;

    private String username;

    private boolean enabled;

}
