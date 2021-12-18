package org.github.zsun.java.puruantraining.chapter11redismysqldemo.Controller;

import org.github.zsun.java.puruantraining.chapter11redismysqldemo.model.Student;
import org.github.zsun.java.puruantraining.chapter11redismysqldemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chapter11")
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping("/saveStudent")
    public void saveStudent(@RequestParam(name = "id") Long id,
                            @RequestParam(name = "name") String name,
                            @RequestParam(name = "score") String score) {
        Student newStudent = new Student();
        newStudent.setId(id);
        newStudent.setName(name);
        newStudent.setScore(score);
        studentService.saveStudent(newStudent);
    }

    @RequestMapping("/findById/{id}")
    public Student findByID(@PathVariable String id) {
        return studentService.findById(id);
    }

    @RequestMapping("/deleteById/{id}")
    public void deleteByID(@PathVariable String id) {
        studentService.deleteById(id);
    }
}
