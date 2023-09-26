package com.yorramn.gerenciaacl.repositories.interfaces;

import com.yorramn.gerenciaacl.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface RoleRepositoryInterface extends JpaRepository<Role, Long> {
    @Query("SELECT 'name' from Role")
    List<String> findAllAndSelectOnlyName();
}
