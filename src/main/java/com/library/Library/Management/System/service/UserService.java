package com.library.Library.Management.System.service;

import com.library.Library.Management.System.model.User;
import com.library.Library.Management.System.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService
{
    @Autowired
    private UserRepo userRepo;

    public List<User> getAllUsers()
    {
        return userRepo.findAll();
    }

    public User addUser(User user)
    {
        userRepo.save(user);
        return user;
    }

    public ResponseEntity<Optional<User>> deleteUser(int id)
    {
        if(userRepo.existsById(id))
        {
            Optional<User> temp = userRepo.findById(id);
            userRepo.deleteById(id);
            return new ResponseEntity<>(temp, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
