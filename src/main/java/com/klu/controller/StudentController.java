package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import com.klu.entity.Student;
import com.klu.model.StudentManager;

@RestController
@RequestMapping("/crud")
@ResponseBody
public class StudentController {
  @Autowired
  StudentManager sm;

  @PostMapping("/insert")
  @ResponseBody
  public String insert(@RequestBody Student s2) {
    return sm.insertData(s2);
  }

  @GetMapping("/alldata")
  @ResponseBody
  public List<Student> getAllData() {
    return sm.getData();
  }

    // Convenience endpoints for browser/manual testing
    // Example: http://localhost:8080/crud/insertByParams?sname=Kumar&sdept=CSE
    @GetMapping("/insertByParams")
    public Student insertByParams(@RequestParam String sname, @RequestParam String sdept) {
      Student s = new Student();
      s.setSname(sname);
      s.setSdept(sdept);
      return sm.insertAndReturn(s);
    }

    // Example: http://localhost:8080/crud/get/1
    @GetMapping("/get/{sid}")
    public org.springframework.http.ResponseEntity<Student> getById(@PathVariable Long sid) {
      var os = sm.getById(sid);
      return os.map(org.springframework.http.ResponseEntity::ok).orElseGet(() -> org.springframework.http.ResponseEntity.notFound().build());
    }

    // Example: http://localhost:8080/crud/updateName/1?sname=New
    @GetMapping("/updateName/{sid}")
    public org.springframework.http.ResponseEntity<?> updateNameByParams(@PathVariable Long sid, @RequestParam String sname) {
      var os = sm.updateName(sid, sname);
      return os.map(v -> org.springframework.http.ResponseEntity.ok(v)).orElseGet(() -> org.springframework.http.ResponseEntity.notFound().build());
    }

    // Example: http://localhost:8080/crud/delete/1
    @GetMapping("/delete/{sid}")
    public org.springframework.http.ResponseEntity<String> deleteById(@PathVariable Long sid) {
      var os = sm.getById(sid);
      if (os.isEmpty()) return org.springframework.http.ResponseEntity.notFound().build();
      sm.deleteById(sid);
      return org.springframework.http.ResponseEntity.ok("deleted id:" + sid);
    }

}
