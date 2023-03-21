package com.backend.controller;

import com.backend.model.Branch;
import com.backend.model.Employee;
import com.backend.service.BranchService;
import com.backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    BranchService branchService;

    @GetMapping("branches")
    public List<Branch> getAllBranch() {
        return branchService.getAll();
    }

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @PostMapping
    public Employee create(@RequestBody Employee employee){
        return  employeeService.save(employee);
    }

    @GetMapping("/{id}")
    public Employee showEdit(@PathVariable long id){
        return employeeService.findById(id);
    }

    @PutMapping("/{id}")
    public Employee edit(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        employeeService.delete(id);
    }

    @GetMapping("/search")
    public List<Employee> searchByName(String search) {
        return employeeService.searchByName(search);
    }

    @GetMapping("/sortBy")
    public List<Employee> sortBy(String sort){
        return employeeService.sortBy(sort);
    }

    @GetMapping("/searchByBranch")
    public List<Employee> searchByBranch(Long idBranch){
        return employeeService.searchByBranch(idBranch);
    }

    @GetMapping("/sumSalary")
    public Long sumSalary(){
        return employeeService.sumSalary();
    }
}
