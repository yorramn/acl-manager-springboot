package com.yorramn.gerenciaacl.init;

import com.yorramn.gerenciaacl.models.Role;
import com.yorramn.gerenciaacl.models.User;
import com.yorramn.gerenciaacl.repositories.RoleRepository;
import com.yorramn.gerenciaacl.repositories.UserRepository;
import com.yorramn.gerenciaacl.seeders.UserSeeder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.HashSet;
import java.util.Set;

public class StartSeeders implements CommandLineRunner {
    UserSeeder userSeeder;

    public StartSeeders(UserSeeder userSeeder) {
        this.userSeeder = userSeeder;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("oi");
        this.userSeeder.run();
    }
}
