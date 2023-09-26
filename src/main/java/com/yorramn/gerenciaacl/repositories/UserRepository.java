package com.yorramn.gerenciaacl.repositories;

import com.yorramn.gerenciaacl.models.User;
import com.yorramn.gerenciaacl.repositories.interfaces.UserRepositoryInterface;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserRepository {
    final UserRepositoryInterface userRepositoryInterface;

    public UserRepository(UserRepositoryInterface userRepositoryInterface) {
        this.userRepositoryInterface = userRepositoryInterface;
    }

    @Transactional
    public User save(User user) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return this.userRepositoryInterface.save(user);
    }

    public User findUserByEmail(String email) {
        return this.userRepositoryInterface.findUserByEmail(email);
    }

    public User findUserByName(String name) {
        return this.userRepositoryInterface.findUserByName(name);
    }
}
