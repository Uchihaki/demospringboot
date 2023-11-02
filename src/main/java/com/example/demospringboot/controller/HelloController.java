package com.example.demospringboot.controller;/*
@Controller: Dung de dinh nghia duong dan tra ra HTML
@ResponseBody: Giup Controller tra ra String de viet API

@RestController: Ket hop Controller and ResponseBody => Viet API
 */

import com.example.demospringboot.payload.request.LoginRequest;
import com.example.demospringboot.payload.request.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hello")
public class HelloController {

    // Tham so truyen tren trinh duyet: @RequestParam
    // Tham so truyen ngam @RequestParam
    // Tham so dong vai tro la duong dan @RPathVariable
    // Tham so ngam la doi tuong @RequestBody
    // Get chi truyen tham so tren trinh duyet
    @GetMapping("")
    public String hello(@RequestParam String hoten, @RequestParam int tuoi) {
        return "Hello Spring Boot" + hoten + " tuoi: " + tuoi;
    }

    // POST
    // form-data: ho tro truyen file
    // form url: ko ho tro truyen file
    // raw: truyen len mot doi tuong => pho bien nhat
    // ResquestBody => raw
    @PostMapping ("cybersoft")
    public String helloCyber(@RequestBody LoginRequest loginRequest) {
        return "Hello Cyber Soft" + loginRequest.getUsername() + " - " + loginRequest.getPassword();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable int id) {

        return new ResponseEntity<>("Update " + id, HttpStatus.OK);
    }


    @RestController
    @RequestMapping("/student")
    public class StudentController {

        private List<Student> studentList = new ArrayList<>();
        @PostMapping ("/add1")
        public ResponseEntity<?> addStudent(@RequestBody Student student) {
            studentList.add(student);
            return new ResponseEntity<>(studentList, HttpStatus.OK);
        }

        @PostMapping("/{name}/{age}")
        public ResponseEntity<?> updateS(@PathVariable String name, @PathVariable int age ) {
            Student student = new Student();
            student.setAge(age);
            student.setName(name);
            studentList.add(student);
            return new ResponseEntity<>(studentList, HttpStatus.OK);
        }

        @PostMapping("/add2")
        public ResponseEntity<?> addS(Student student) {
            studentList.add(student);
            return new ResponseEntity<>(studentList, HttpStatus.OK);
        }
    }

}
