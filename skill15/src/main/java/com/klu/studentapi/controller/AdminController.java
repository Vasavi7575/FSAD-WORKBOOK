package com.klu.studentapi.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @PostMapping("/add")
    public String addData() {
        return "Admin added data successfully";
    }

    @DeleteMapping("/delete")
    public String deleteData() {
        return "Admin deleted data successfully";
    }
}