package com.picture.service.mapper;

import com.picture.service.dto.PictureDto;
import com.picture.service.entity.PictureEntity;
import org.mapstruct.Mapper;


@Mapper
public interface PictureMapper {

    PictureEntity unMap(PictureDto dto);
    PictureDto map(PictureEntity entity);

}
