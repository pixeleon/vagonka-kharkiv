package net.khpi.shevvaddm.vagonka.service;

import net.khpi.shevvaddm.vagonka.dto.UserDto;

import java.util.List;

public interface UserService {

    void insertUser(UserDto userDto);

    void updateUser(UserDto userDto);

    void deleteUser(UserDto userDto);

    List<UserDto> findAllUsers();
}
