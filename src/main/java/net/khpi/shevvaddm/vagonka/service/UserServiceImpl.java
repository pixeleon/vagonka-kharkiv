package net.khpi.shevvaddm.vagonka.service;

import net.khpi.shevvaddm.vagonka.dao.UserDao;
import net.khpi.shevvaddm.vagonka.dao.UserRoleDao;
import net.khpi.shevvaddm.vagonka.dto.UserDto;
import net.khpi.shevvaddm.vagonka.model.User;
import net.khpi.shevvaddm.vagonka.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private static final Long DEFAULT_USER_ROLE_ID = 1l;
    private static final long ADMIN_USER_ROLE_ID = 2L;

    private UserRoleDao userRoleDao;
    private UserDao userDao;

    @Autowired
    public void setUserRoleDao(UserRoleDao userRoleDao) {
        this.userRoleDao = userRoleDao;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void insertUser(UserDto userDto) {
        userDao.save(convertUserDtoToUserEntity(userDto));
    }

    @Transactional
    @Override
    public void updateUser(UserDto userDto) {
        userDao.save(convertUserDtoToUserEntity(userDto));
    }

    @Transactional
    @Override
    public void deleteUser(UserDto userDto) {
        userDao.delete(convertUserDtoToUserEntity(userDto));
    }

    @Transactional(readOnly = true)
    @Override
    public List<UserDto> findAllAdminUsers() {
        return userDao.findAllByUserRoleId(ADMIN_USER_ROLE_ID).stream()
                .map(this::convertUserEntityToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto convertUserEntityToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setUserId(userDto.getUserId());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setEmail(user.getEmail());
        userDto.setUserRoleId(userDto.getUserRoleId());
        return userDto;
    }

    @Override
    public User convertUserDtoToUserEntity(UserDto dto) {
        User user = new User();
        user.setUserId(dto.getUserId());
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());

        UserRole userRole = userRoleDao.findById(DEFAULT_USER_ROLE_ID)
                .orElseThrow(() -> new ServiceException(
                        "Default user role not found by ID: "));
        user.setUserRole(userRole);

        return user;
    }

}
