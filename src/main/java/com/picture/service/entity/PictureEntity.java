package com.picture.service.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "pictures")
@NoArgsConstructor
@Data
@ToString
public class PictureEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;
    private String category;
    private Boolean accepted;
    @Lob
    private byte[] image;

    @Column(name = "pic_name")
    private String pictureName;

}
