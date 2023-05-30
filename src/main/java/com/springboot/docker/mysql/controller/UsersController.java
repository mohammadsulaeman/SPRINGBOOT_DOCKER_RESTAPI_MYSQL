package com.springboot.docker.mysql.controller;

import com.springboot.docker.mysql.entity.Users;
import com.springboot.docker.mysql.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/users")
public class UsersController {
    private UsersService usersService;

    @GetMapping
    public ResponseEntity<List<Users>> fetchUsersAll(){
        List<Users> usersList = usersService.fetchUsersAll();
        return new ResponseEntity<>(usersList, HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<Users> saveUsers(@RequestBody Users users){
        Users addUsers = usersService.saveUsers(users);
        return new ResponseEntity<>(addUsers,HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Users> fetchUsersById(@PathVariable("id") Integer usersId)
    {
        Users users = usersService.fetchUsersById(usersId);
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Users> updateUsers(@PathVariable("id") Integer usersId, @RequestBody Users users){
       Users updateData = new Users();
       updateData.setUsersId(usersId);
       updateData.setUsersFirstName(users.getUsersFirstName());
       updateData.setUsersLastName(users.getUsersLastName());
       updateData.setUserPhones(users.getUserPhones());
       updateData.setUsersEmail(users.getUsersEmail());

       Users UsersUpdate = usersService.updateUsers(updateData);
       return new ResponseEntity<>(UsersUpdate,HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUsersById(@PathVariable("id") Integer usersId)
    {
        usersService.deleteUsersById(usersId);
        return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
    }
}
