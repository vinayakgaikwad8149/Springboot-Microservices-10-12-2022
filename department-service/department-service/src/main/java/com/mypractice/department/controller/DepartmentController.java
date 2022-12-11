package com.mypractice.department.controller;

import com.mypractice.department.Entity.Department;
import com.mypractice.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment( @RequestBody Department department){
        log.info("inside the save method of the controller");
       return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department findDepartmentById( @PathVariable(value = "id") Long departmentId){
        log.info("inside the findDepartmentById method of the controller");
        return departmentService.findDepartmentById(departmentId);
    }
}
