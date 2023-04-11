package com.api.vendas.repository;


import com.api.vendas.entity.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository {

    public void save(Student student);

}
