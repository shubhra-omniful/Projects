package com.masai.repository;

import com.masai.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager,Integer> {

    @Query("from Manager where name = ?1")
    Manager getManagerByName(String name);

}
