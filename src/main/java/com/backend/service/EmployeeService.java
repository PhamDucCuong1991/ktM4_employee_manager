package com.backend.service;

import com.backend.model.Employee;
import com.backend.repository.IEmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Component
public class EmployeeService {
    @Autowired
    IEmployeeRepo iEmployeeRepo;

    public List<Employee> getAll() {
        return (List<Employee>) iEmployeeRepo.findAll();
    }

    public List<Employee> searchByName(String search) {
        return iEmployeeRepo.searchByNameEmployeeContaining(search);
    }

    public Employee save(Employee employee) {
        return iEmployeeRepo.save(employee);
    }

    public Employee findById(long id) {
        return iEmployeeRepo.findById(id).orElse(null);
    }

    public Employee delete(long id) {
        Employee employee = findById(id);
        iEmployeeRepo.deleteById(id);
        return employee;

    }

    public List<Employee> sortBy(String sort) {
        List<Employee> products = getAll();
        switch (sort) {
            case "name":
                products.sort(Comparator.comparing(Employee::getNameEmployee));
                break;
            case "age":
                products.sort(Comparator.comparing(Employee::getAge));
                Collections.reverse(products);
                break;
            case "salary":
                products.sort(Comparator.comparing(Employee::getSalary));
                Collections.reverse(products);
                break;
        }
        return products;
    }

    public List<Employee> searchByBranch(Long idBranch){
        return iEmployeeRepo.searchAllByBranch_Id(idBranch);
    }

    public Long sumSalary(){
        return iEmployeeRepo.sumSalary();
    }
}
