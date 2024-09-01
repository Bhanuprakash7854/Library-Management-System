package com.library.Library.Management.System.controller;

import com.library.Library.Management.System.model.User;
import com.library.Library.Management.System.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController
{
    @Autowired
    private UserService userService;

    @GetMapping("/allusers")
    public List<User> getAllUsers()
    {
        return userService.getAllUsers();
    }

    @PostMapping("/adduser")
    public User addUser(@RequestBody User user)
    {
        return userService.addUser(user);
    }
    @PostMapping("delete/{id}")
    public ResponseEntity<Optional<User>> deleteUser(@PathVariable int id)
    {
        return userService.deleteUser(id);
    }
}
