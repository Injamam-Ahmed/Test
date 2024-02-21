package com.injamam.test.repository;

import com.injamam.test.Model.*;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TestdataRepository extends JpaRepository<Testdata, Integer>, JpaSpecificationExecutor<Testdata> {

    void update(Integer id, TestdataUpdateVO vO);

    Page<TestdataDTO> query(TestdataQueryVO vO);

    void delete(Integer id);
}