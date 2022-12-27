package com.picture.service.entity;

import com.picture.service.service.util.PictureUtil;
import com.picture.service.service.util.UserUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "users")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Email(regexp = UserUtil.regexPattern,message = "invalid email")
    @Column(unique = true,nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private String username;

    private boolean enabled;


}
