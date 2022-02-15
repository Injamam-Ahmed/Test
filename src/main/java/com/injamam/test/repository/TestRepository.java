package com.injamam.test.repository;

import com.injamam.test.Model.Testtable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Testtable, Integer> {

    @Query(value = "select * from testdata where FirstName = :firstName AND LastName = :lastName", nativeQuery = true)
    public Testtable getquery(@Param("firstName") String firstName,
            @Param("lastName") String lastName);

    public Testtable findByFirstNameAndLastName(String firstName, String lastName);

    public Testtable findById(int id);
}
