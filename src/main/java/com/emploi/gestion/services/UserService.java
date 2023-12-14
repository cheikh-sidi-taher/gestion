package com.emploi.gestion.services;



import java.util.List;

import com.emploi.gestion.dto.UserDto;
import com.emploi.gestion.models.User;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}