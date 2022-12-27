package com.picture.service.repository;

import com.picture.service.entity.PictureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<PictureEntity,Integer> {

    List<PictureEntity> findAllByAcceptedTrue();
    List<PictureEntity>findAllByAcceptedFalse();
    List<PictureEntity>findAllByAcceptedIsNull();
    Optional<PictureEntity>findById(int id);

}
