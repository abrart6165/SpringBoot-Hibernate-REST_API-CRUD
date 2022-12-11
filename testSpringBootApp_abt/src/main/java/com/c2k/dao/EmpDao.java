package com.c2k.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.c2k.model.Employee;
@Repository
public interface EmpDao extends JpaRepository<Employee, Integer>{

}
