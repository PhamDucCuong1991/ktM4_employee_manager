package com.backend.repository;

import com.backend.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IEmployeeRepo extends PagingAndSortingRepository<Employee,Long> {
    List<Employee> searchByNameEmployeeContaining(String search);
    List<Employee> searchAllByBranchContaining(String branch);
    List<Employee> searchAllByBranch_Id(Long idBranch);

    @Query("select Sum(salary) from Employee")
    Long sumSalary();

}
