package com.s4r.persistence.user;

import com.s4r.domain.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserEntity,Long> {

}