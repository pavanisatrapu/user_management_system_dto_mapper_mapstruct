package com.myprojects.user_management_system_dto_mapper_mapstruct.repository;

import com.myprojects.user_management_system_dto_mapper_mapstruct.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
