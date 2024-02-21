package com.injamam.test.UserController;

import java.util.Objects;

import com.injamam.test.Model.Testtable;
import com.injamam.test.repository.TestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/demo")
public class UserController {
    @Autowired
    private TestRepository testRepository;

    @GetMapping("/all")
    public @ResponseBody Iterable<Testtable> getallUser() {
        try {
            return testRepository.findAll();
        } catch (Exception ex) {
            return null; 

        }
    }

    @PostMapping("/add")
    public String addNewUser(@RequestBody Testtable testtable) {
        System.out.println("Welcome" + testtable.toString());
        try {
            testRepository.save(testtable);
            return "Data has been saved Successfully";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "Internal Server Error, Try again";
        }
    }

    @PostMapping("/query")
    public ResponseEntity<Testtable> getdata(@RequestBody Testtable testtable) {
        Testtable ta;
        try {
            ta = testRepository.findByFirstNameAndLastName(testtable.getFirstName(), testtable.getLastName());
            System.out.println(ta);
            if (ta == null) {
                throw new Exception();
            }
            return new ResponseEntity<>(ta, HttpStatus.OK);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return new ResponseEntity<>(/* "User not found", */ HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @PostMapping("/Test/{id}")
    public ResponseEntity<Testtable> getById(@PathVariable("id") int id) {
        try {
            Testtable ta = testRepository.findById(id);
            if (ta == null) {
                throw new Exception();
            }
            return new ResponseEntity<>(ta, HttpStatus.OK);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return new ResponseEntity<>(/* "No record available with the ID", */ HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/Test/{id}")
    public ResponseEntity<Testtable> updateData(@PathVariable("id") int id, @RequestBody Testtable testtable) {
        try {
            Testtable ta = testRepository.findById(id);
            System.out.println(ta.toString());
            // if (ta == null) {
            // throw new Exception();
            // }
            if (Objects.nonNull(testtable.getFirstName()) && !"".equalsIgnoreCase(testtable.getFirstName())) {
                ta.setFirstName(testtable.getFirstName());
            }
            if (Objects.nonNull(testtable.getLastName()) && !"".equalsIgnoreCase(testtable.getLastName())) {
                ta.setLastName(testtable.getLastName());
            }
            return new ResponseEntity<>(testRepository.save(ta), HttpStatus.OK);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return new ResponseEntity<>(/* "No record available with the ID", */ HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/Test/{id}")
    public String deleteData(@PathVariable("id") int id) {
        try {
            testRepository.deleteById(id);
            return "Data deleted Successfully";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "Internal Server Error, Try again";
        }
    }

}
