package com.klu.studentapi.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/profile")
    public String getProfile() {
        return "Employee profile accessed";
    }
}