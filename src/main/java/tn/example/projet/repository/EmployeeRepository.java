package tn.example.projet.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.example.projet.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository <Employee, Integer>  {

}
