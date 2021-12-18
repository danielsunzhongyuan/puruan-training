package org.github.zsun.java.puruantraining.chapter11redisdemo.service;

import org.github.zsun.java.puruantraining.chapter11redisdemo.model.Student;
import org.github.zsun.java.puruantraining.chapter11redisdemo.repo.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentDao studentDao;

    public void saveStudent(Student student) {
        studentDao.saveStudent(String.valueOf(student.getId()), 3600, student);
    }

    public Student findById(String id) {
        return studentDao.findById(id);
    }

    public void deleteById(String id) {
        studentDao.deleteById(id);
    }
}
