package com.springboot.docker.mysql.service;

import com.springboot.docker.mysql.entity.Users;
import java.util.List;

public interface UsersService {
    List<Users> fetchUsersAll();

    Users saveUsers(Users users);

    Users fetchUsersById(Integer userId);

    Users updateUsers(Users users);

    void deleteUsersById(Integer usersId);
}
