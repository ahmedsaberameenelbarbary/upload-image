package com.picture.service.mapper;


import com.picture.service.dto.UserDto;
import com.picture.service.entity.UserEntity;
import org.mapstruct.Mapper;


@Mapper
public interface UserMapper {

    UserEntity unMap(UserDto dto);
    UserDto map(UserEntity entity);

}
