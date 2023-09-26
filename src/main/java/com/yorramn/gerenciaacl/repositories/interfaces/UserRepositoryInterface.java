package com.yorramn.gerenciaacl.repositories.interfaces;

import com.yorramn.gerenciaacl.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserRepositoryInterface extends JpaRepository<User, Long>, PagingAndSortingRepository<User, Long>, CrudRepository<User, Long> {
    User findUserByEmail(String email);

    User findUserByName(String name);
}
