package com.myprojects.user_management_system_dto_mapper_mapstruct.service;

import com.myprojects.user_management_system_dto_mapper_mapstruct.dto.UserDto;
import com.myprojects.user_management_system_dto_mapper_mapstruct.entity.User;
import com.myprojects.user_management_system_dto_mapper_mapstruct.mapper.UserMapperMapStruct;
import com.myprojects.user_management_system_dto_mapper_mapstruct.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        //dto to jpa entity
        User user= UserMapperMapStruct.MAPPER.toUser(userDto);
        User savedUser =userRepository.save(user);

        //jpa entity to dto
        return UserMapperMapStruct.MAPPER.toUserDto(user);
    }

    @Override
    public Optional<UserDto> getUserById(Long id) {
        Optional<User> user=userRepository.findById(id);
        return Optional.ofNullable(UserMapperMapStruct.MAPPER.toUserDto(user.get()));
    }

    @Override
    public List<UserDto> getAllUsers() {

        List<UserDto> userDtoList= new ArrayList<UserDto>();
        List<User> userList=userRepository.findAll();
        int userListSize=userList.size();
        for (int i=0;i<userListSize;i++){
            userDtoList.add(UserMapperMapStruct.MAPPER.toUserDto(userList.get(i)));
        }
        return userDtoList;
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User user=new User(userDto.getUserId(), userDto.getUserName(), userDto.getUserEmail(), userDto.getUserAge());
        User existingUser=userRepository.findById(user.getUserId()).get();
        existingUser.setUserName(user.getUserName());
        existingUser.setUserEmail(user.getUserEmail());
        existingUser.setUserAge(user.getUserAge());
        User updatedUser =userRepository.save(user);
        return UserMapperMapStruct.MAPPER.toUserDto(user);
    }

    @Override
    public UserDto deleteUser(Long id) {
        User wantToDelete=userRepository.findById(id).get();
        userRepository.deleteById(id);
        return UserMapperMapStruct.MAPPER.toUserDto(wantToDelete);
    }


}
