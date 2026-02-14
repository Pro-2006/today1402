package com.klu.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.entity.Student;
import com.klu.repository.StudentRepository;

@Service
public class StudentManager {
  @Autowired
  StudentRepository sr;

  public String insertData(Student s1) {
    sr.save(s1);
    return "data was inserted sucessfully";
  }

  public Student insertAndReturn(Student s1) {
    return sr.save(s1);
  }

  public java.util.Optional<Student> getById(Long id) {
    return sr.findById(id);
  }

  public void deleteById(Long id) {
    sr.deleteById(id);
  }

  public java.util.Optional<Student> updateName(Long id, String sname) {
    var os = sr.findById(id);
    if (os.isEmpty()) return java.util.Optional.empty();
    Student s = os.get();
    s.setSname(sname);
    sr.save(s);
    return java.util.Optional.of(s);
  }
  public List<Student> getData() {
    return sr.findAll();
  }
}
