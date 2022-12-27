package com.picture.service.service;

import com.picture.service.dto.PictureDto;
import com.picture.service.response.SuccessResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PictureService {

     String addImage(PictureDto pictureDto, MultipartFile file)throws IOException;
    SuccessResponse getAllUnProcessedImages();
    SuccessResponse getAcceptedImages();
    SuccessResponse getRejectedImages();
    SuccessResponse acceptImage(int id);
    SuccessResponse rejectImage(int id);

    String logEndMessage = "End :: {} :: method :: Time: {}";
}
