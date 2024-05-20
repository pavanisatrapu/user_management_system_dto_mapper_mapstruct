package com.myprojects.user_management_system_dto_mapper_mapstruct.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserDto {

    private Long userId;
    private String userName;
    private String userEmail;
    private int userAge;
}
