package com.yorramn.gerenciaacl.seeders;

import com.yorramn.gerenciaacl.models.User;
import com.yorramn.gerenciaacl.repositories.RoleRepository;
import com.yorramn.gerenciaacl.repositories.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserSeeder {
    UserRepository userRepository;
    RoleRepository roleRepository;

    public UserSeeder(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public void run(){
        User user = userRepository.findUserByName("admin");
        if(user == null){
            user = new User("admin", "admin@admin.com", "admin", this.roleRepository.findAll());
            this.userRepository.save(user);
        }
    }
}
