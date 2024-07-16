package com.masai.repository;

import com.masai.model.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeRepository extends JpaRepository<Office, Integer> {

    @Query("from Office where name = ?1")
    Office getOfficeByName(String name);

}
