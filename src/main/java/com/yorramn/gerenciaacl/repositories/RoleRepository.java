package com.yorramn.gerenciaacl.repositories;

import com.yorramn.gerenciaacl.models.Role;
import com.yorramn.gerenciaacl.repositories.interfaces.RoleRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class RoleRepository {
    final RoleRepositoryInterface roleRepositoryInterface;

    public RoleRepository(RoleRepositoryInterface roleRepositoryInterface) {
        this.roleRepositoryInterface = roleRepositoryInterface;
    }

    public List<String> findAllRolesAndReturnsOnlyName() {
        return this.roleRepositoryInterface.findAllAndSelectOnlyName();
    }

    public Collection<Role> findAll() {
        return this.roleRepositoryInterface.findAll();
    }
}
