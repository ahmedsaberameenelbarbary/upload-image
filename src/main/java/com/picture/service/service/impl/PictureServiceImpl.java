package com.picture.service.service.impl;


import com.picture.service.config.FileUploadConfig;
import com.picture.service.dto.PictureDto;
import com.picture.service.entity.PictureEntity;
import com.picture.service.exception.cust.exeption.InvalidImageException;
import com.picture.service.exception.cust.exeption.NotFoundRecordException;
import com.picture.service.mapper.PictureMapper;
import com.picture.service.repository.ImageRepository;
import com.picture.service.response.SuccessResponse;
import com.picture.service.service.PictureService;
import com.picture.service.service.util.PictureUtil;
import com.picture.service.service.util.UserUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PictureServiceImpl implements PictureService {

    private final ImageRepository repository;

    private final PictureMapper mapper;


    public String addImage(PictureDto pictureDto, MultipartFile file) throws IOException {

        Long start = System.currentTimeMillis();

        String methodName = "addImage";

        if (!PictureUtil.validCategory(pictureDto.getCategory()))
            throw new InvalidImageException("invalid category,,,,,");

        String imageName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));

        if (!PictureUtil.validExtension(PictureUtil.getFileExtension(imageName)))
            throw new InvalidImageException("invalid exception,,,,,");

        pictureDto.setPictureName(imageName);

        pictureDto.setImage(file.getBytes());

        PictureEntity pictureEntity = repository.save(mapper.unMap(pictureDto));

        if (Objects.nonNull(pictureEntity)) {

            //adding the image to an external folder
            FileUploadConfig.saveFile(imageName, file);

            log.info(logEndMessage, methodName, System.currentTimeMillis() - start);

            return "image added successfully";
        }

        throw new HibernateException("un able to save");
    }

    public SuccessResponse getAllUnProcessedImages() {

        Long start = System.currentTimeMillis();

        String methodName = "getAllUnProcessedImages";


        UserUtil.isAdminUser();

        List<PictureDto> data = repository.findAllByAcceptedIsNull().stream().map(mapper::map).toList();

        log.info(logEndMessage, methodName, System.currentTimeMillis() - start);

        return SuccessResponse.ok(data);
    }

    public SuccessResponse getAcceptedImages() {

        Long start = System.currentTimeMillis();

        String methodName = "getAcceptedImages";

        List<PictureDto> data = repository.findAllByAcceptedTrue().stream().map(mapper::map).toList();

        log.info(logEndMessage, methodName, System.currentTimeMillis() - start);

        return SuccessResponse.ok(data);
    }

    public SuccessResponse getRejectedImages() {

        Long start = System.currentTimeMillis();

        String methodName = "getAcceptedImages";

        UserUtil.isAdminUser();

        List<PictureDto> data = repository.findAllByAcceptedFalse().stream().map(mapper::map).toList();

        log.info(logEndMessage, methodName, System.currentTimeMillis() - start);

        return SuccessResponse.ok(data);
    }

    public SuccessResponse acceptImage(int id) {

        Long start = System.currentTimeMillis();

        String methodName = "acceptImage";

        UserUtil.isAdminUser();

        Optional<PictureEntity> optionalPicture = repository.findById(id);

        if (optionalPicture.isPresent()) {

            PictureEntity entity = optionalPicture.get();

            entity.setAccepted(Boolean.TRUE);

            repository.save(entity);

            log.info(logEndMessage, methodName, System.currentTimeMillis() - start);

            return SuccessResponse.ok(mapper.map(entity));
        }

        throw new NotFoundRecordException(" no record for this id:" + id);

    }

    public SuccessResponse rejectImage(int id) {

        Long start = System.currentTimeMillis();

        String methodName = "rejectImage";


        UserUtil.isAdminUser();

        Optional<PictureEntity> optionalPicture = repository.findById(id);

        if (optionalPicture.isPresent()) {

            PictureEntity entity = optionalPicture.get();

            entity.setAccepted(Boolean.FALSE);

            entity.setImage(null);

            repository.save(entity);

            log.info(logEndMessage, methodName, System.currentTimeMillis() - start);

            return SuccessResponse.ok(mapper.map(entity));
        }

        throw new NotFoundRecordException(" no record for this id:" + id);

    }


}
