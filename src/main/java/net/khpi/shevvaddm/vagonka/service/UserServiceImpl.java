package net.khpi.shevvaddm.vagonka.service;

import net.khpi.shevvaddm.vagonka.dao.UserDao;
import net.khpi.shevvaddm.vagonka.dao.UserRoleDao;
import net.khpi.shevvaddm.vagonka.dto.DtoUtils;
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

    private static final long DEFAULT_USER_ROLE_ID = 1L;
    private static final long ADMIN_USER_ROLE_ID = 2L;

    private DtoUtils dtoUtils;
    private UserRoleDao userRoleDao;
    private UserDao userDao;

    @Autowired
    public void setDtoUtils(DtoUtils dtoUtils) {
        this.dtoUtils = dtoUtils;
    }

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
        long userRoleId = userDto.getUserRoleId();
        User user = dtoUtils.mapUserDtoToUserEntity(userDto);
        UserRole userRole = getUserRole(userRoleId);
        user.setUserRole(userRole);
        userDao.save(user);
    }

    private UserRole getUserRole(long userRoleId) {
        return userRoleDao.findById(userRoleId)
                .orElse(userRoleDao.findById(DEFAULT_USER_ROLE_ID)
                        .orElseThrow(() -> new ServiceException("Unable to set user role")));
    }

    @Transactional
    @Override
    public void updateUser(UserDto userDto) {
        userDao.save(dtoUtils.mapUserDtoToUserEntity(userDto));
    }

    @Transactional
    @Override
    public void deleteUser(UserDto userDto) {
        userDao.delete(dtoUtils.mapUserDtoToUserEntity(userDto));
    }

    @Transactional
    @Override
    public List<UserDto> findAllUsers() {
        return userDao.findAll()
                .stream()
                .map(dtoUtils::mapUserEntityToUserDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<UserDto> findAllNotAdminUsers() {
        return userDao.findAll()
                .stream()
                .filter(u ->
                        u.getUserRole().getUserRoleId() != ADMIN_USER_ROLE_ID)
                .map(dtoUtils::mapUserEntityToUserDto)
                .collect(Collectors.toList());
    }
}
