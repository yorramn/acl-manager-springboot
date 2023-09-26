package com.yorramn.gerenciaacl.services;


import com.yorramn.gerenciaacl.models.User;
import com.yorramn.gerenciaacl.repositories.UserRepository;
import com.yorramn.gerenciaacl.requests.UserRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(UserRequest userRequestData) {
        var user = new User();
        BeanUtils.copyProperties(userRequestData, user);
        return this.userRepository.save(user);
    }

    public User findUserByEmail(String email) {
        return this.userRepository.findUserByEmail(email);
    }

    public User findUserByName(String name) {
        return this.userRepository.findUserByName(name);
    }
}
