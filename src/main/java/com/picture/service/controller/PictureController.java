package com.picture.service.controller;


import com.picture.service.dto.PictureDto;
import com.picture.service.response.SuccessResponse;
import com.picture.service.service.PictureService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 *
 * @author ahmedSaber
 *
 */

@RestController
@RequestMapping("/picture")
@RequiredArgsConstructor
@Tag(name = "PICTURE-CONTROLLER")
public class PictureController {

    private final PictureService service;

    @Operation(summary = "insert just for Login user " ,description = "add new Picture with description and category")
    @PostMapping(value = "", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> addImage(
            @RequestParam("picture") MultipartFile multipartFile,
            @RequestParam("description") String description,
            @RequestParam("category") String category) throws IOException {


        return ResponseEntity.ok().body(service.addImage(new PictureDto(description, category), multipartFile));
    }

    @Operation(summary = "accept image by id just for admin " ,description = "mark image as accepted ")
    @PutMapping("/accept/{id}")
    public ResponseEntity<SuccessResponse> acceptImage(@PathVariable int id) {

        return ResponseEntity.ok().body(service.acceptImage(id));
    }

    @Operation(summary = "reject image by id just for admin" ,description = "mark image as accepted ")
    @PutMapping("/reject/{id}")
    public ResponseEntity<SuccessResponse> rejectImage(@PathVariable int id) {

        return ResponseEntity.ok().body(service.rejectImage(id));
    }

    //@RolesAllowed("admin")
    @Operation(summary = "get all unprocessed images just for admin" ,description = "retrieve  all un processed images ")
    @GetMapping("/unprocessed")
    public ResponseEntity<SuccessResponse> getUnProcessedImages() {

        return ResponseEntity.ok().body(service.getAllUnProcessedImages());
    }

    @Operation(summary = "get all accepted images available for all" ,description = "retrieve  all accepted images ")
    @GetMapping("/accepted")
    public ResponseEntity<SuccessResponse> getAcceptedImages() {

        return ResponseEntity.ok().body(service.getAcceptedImages());
    }

    @Operation(summary = "get all rejected images available for admin" ,description = "retrieve  all rejected images ")
    @GetMapping("/rejected")
    public ResponseEntity<SuccessResponse> getRejectedImages() {

        return ResponseEntity.ok().body(service.getRejectedImages());
    }


}
