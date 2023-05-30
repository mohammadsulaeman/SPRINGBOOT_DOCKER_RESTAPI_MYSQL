package com.springboot.docker.mysql.service.impl;

import com.springboot.docker.mysql.entity.Users;
import com.springboot.docker.mysql.repository.UsersRepository;
import com.springboot.docker.mysql.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsersImplService implements UsersService {
    @Autowired
    private UsersRepository usersRepository;
    @Override
    public List<Users> fetchUsersAll() {
        return (List<Users>) usersRepository.findAll();
    }

    @Override
    public Users saveUsers(Users users) {
        return usersRepository.save(users);
    }

    @Override
    public Users fetchUsersById(Integer userId) {
        Optional<Users> usersOptional = usersRepository.findById(userId);
        Users users = null;
        if (usersOptional.isPresent()){
            users = usersOptional.get();
        }else {
            throw new NoSuchElementException("Users tidak ditemukan");
        }
        return users;
    }


    @Override
    public Users updateUsers(Users users) {
      Users updateData = usersRepository.findById(users.getUsersId()).get();
      updateData.setUsersFirstName(users.getUsersFirstName());
      updateData.setUsersLastName(users.getUsersLastName());
      updateData.setUserPhones(users.getUserPhones());
      updateData.setUsersEmail(users.getUsersEmail());
      return usersRepository.save(updateData);
    }

    @Override
    public void deleteUsersById(Integer usersId) {
        usersRepository.deleteById(usersId);
    }


}
