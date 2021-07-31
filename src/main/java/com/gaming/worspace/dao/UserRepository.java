package com.gaming.worspace.dao;

import com.gaming.worspace.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    boolean existsByEmail(String email);


    @Query("SELECT u FROM User u WHERE u.service_type.id=:id ")
    List<User> findByService_typeId(long id);

    Optional<User> findByEmail(String email);

}
