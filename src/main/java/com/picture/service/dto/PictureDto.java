package com.picture.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PictureDto {

    private int id;
    private String description;
    private String category;
    private byte[] image;
    private String pictureName;
    private Boolean accepted;


    public PictureDto(String description, String category) {
        this.description = description;
        this.category = category;
    }
}
