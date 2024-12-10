package com.folder.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import com.folder.app.dto.ResultDTO;
import com.folder.app.dto.UserDTO;
import com.folder.app.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:8800")
public class DataController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String home() {
        return "Data 준비중...";
    }

    @GetMapping("/api")
    public String api() {
        return "Api Data 준비중...";
    }

    @PostMapping("/findAll")
    public ResultDTO findAll() {
        return userService.findAll();
    }

    @PostMapping("/editById")
    public ResultDTO editById(@RequestBody UserDTO uDto) {
        System.out.println(uDto);
        return userService.editByID(uDto);
    }

    @DeleteMapping("/delete")
    public ResultDTO delete(@RequestParam("no") int no) {
        return userService.delete(no);
    }

    @PutMapping("/save")
    public ResultDTO save(@RequestBody UserDTO uDto) {
        return userService.save(uDto);
    }
}
