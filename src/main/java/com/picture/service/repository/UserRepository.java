package com.picture.service.repository;

import com.picture.service.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {

    Optional<UserEntity> findByUsernameLikeOrEmailLikeAndPassword(String userName,String Email,String password);
}
