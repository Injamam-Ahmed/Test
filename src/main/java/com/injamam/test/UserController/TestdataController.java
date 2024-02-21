package com.injamam.test.UserController;

import com.injamam.test.repository.TestdataRepository;
import com.injamam.test.Model.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/testdata")
public class TestdataController {

    @Autowired
    private TestdataRepository testdataService;

    @PostMapping
    public String save(@RequestBody TestdataVO vO) {
//        return testdataService.save(vO).toString();
        return "";
    }

    @DeleteMapping("/{id}")
    public void delete(@NotNull @PathVariable("id") Integer id) {
        testdataService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@NotNull @PathVariable("id") Integer id, @RequestBody TestdataUpdateVO vO) {
        testdataService.update(id, vO);
    }

    @GetMapping("/{id}")
    public Testdata getById(@NotNull @PathVariable("id") Integer id) {
        return testdataService.getById(id);
    }

    @GetMapping
    public Page<TestdataDTO> query(TestdataQueryVO vO) {
        return testdataService.query(vO);
    }
}
