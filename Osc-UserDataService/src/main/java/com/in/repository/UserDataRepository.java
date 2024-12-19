package com.in.repository;

import com.in.dto.UserLoginDto;
import com.in.entity.UserRegistrationRequestEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataRepository extends JpaRepository<UserRegistrationRequestEntity, String> {

    boolean existsByEmail(String email);

    @Query("SELECT new com.in.dto.UserLoginDto(u.userId, u.name, u.password) FROM UserRegistrationRequestEntity u WHERE u.userId = :userId")
    UserLoginDto findNameAndPasswordByUserId(@Param("userId") String userId);

    @Modifying
    @Transactional
    @Query("UPDATE UserRegistrationRequestEntity u SET u.password = :password WHERE u.email = :email")
    int changePasswordByEmail(@Param("email") String email, @Param("password") String password);
}
