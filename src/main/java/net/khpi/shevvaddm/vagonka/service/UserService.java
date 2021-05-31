package net.khpi.shevvaddm.vagonka.service;

import net.khpi.shevvaddm.vagonka.dto.UserDto;
import net.khpi.shevvaddm.vagonka.model.User;

import java.util.List;

public interface UserService {

    void insertUser(UserDto userDto);
    void updateUser(UserDto userDto);
    void deleteUser(UserDto userDto);
    List<UserDto> findAllAdminUsers();

    UserDto convertUserEntityToUserDto(User user);

    User convertUserDtoToUserEntity(UserDto dto);
}
