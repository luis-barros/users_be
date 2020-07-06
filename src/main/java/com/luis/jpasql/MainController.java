package com.luis.jpasql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MainController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/Users")
    public User addNewUser(@RequestBody User input) {
        userRepository.save(input);
        return input;
    }

    @DeleteMapping(path = "/Users/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userRepository.deleteById(id);
        return "Deleted User: " + id;
    }

    @GetMapping(path = "/Users")
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/Users/{id}")
    public User getUser(@PathVariable Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }
}