package com.tps.device_management.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tps.device_management.entities.Student;


public interface StudentRepository extends CrudRepository<Student, Integer>{

}
