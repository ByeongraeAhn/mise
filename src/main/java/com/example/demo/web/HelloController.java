package com.example.demo.web;

import java.util.List;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class HelloController {

    @Autowired
    UserRepository userRepository;

    // curl -H "Content-Type: application/json" -X POST -d '{"firstName":"BR", "lastName":"AHN"}' http://localhost:8080/user
    @PostMapping
    public User save(@RequestBody User user) throws Exception {

        User responseUser = userRepository.save(user);
        return responseUser;
    }

    // curl -H "Content-Type: application/json" -X PUT -d '{"firstName":"KD", "lastName":"HONG"}' http://localhost:8080/user/1
    @PutMapping("/{id}")
    public User update(@PathVariable("id") Long id, @RequestBody User user) throws Exception {
        user.setId(id);
        User responseUser = userRepository.save(user);
        return responseUser;
    }

    // curl -H "Content-Type: application/json" -X GET http://localhost:8080/user
    @GetMapping
    public List<User> findall() throws Exception {

        List<User> userList = userRepository.findAll();
        return userList;
    }

    // curl -H "Content-Type: application/json" -X GET http://localhost:8080/user/AHN
    @GetMapping("/{lastName}")
    public List<User> findby(@PathVariable("lastName") String lastName) throws Exception {

        List<User> userList = userRepository.findByLastName(lastName);
        return userList;
    }



    

}