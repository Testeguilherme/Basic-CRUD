package com.api.vendas.dao;


import com.api.vendas.entity.Student;

import java.util.List;

public interface StudentDAO {

    public void save(Student student);

    public Student findById(Integer id);

    public List<Student> findAll();

    public List<Student> findByLastName(String theLastName);

    public void update(Student theStudent);

    public void deleteStudent(Integer id);

    public int deleteAll();


}
