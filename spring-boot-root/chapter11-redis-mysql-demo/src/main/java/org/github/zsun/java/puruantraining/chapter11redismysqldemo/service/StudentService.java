package org.github.zsun.java.puruantraining.chapter11redismysqldemo.service;

import org.github.zsun.java.puruantraining.chapter11redismysqldemo.model.Student;
import org.github.zsun.java.puruantraining.chapter11redismysqldemo.repo.StudentMySqlRepo;
import org.github.zsun.java.puruantraining.chapter11redismysqldemo.repo.StudentRedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class StudentService {
    @Autowired
    private StudentRedisDao studentRedisDao;

    @Autowired
    private StudentMySqlRepo studentMySqlRepo;

    public void saveStudent(Student student) {
        studentRedisDao.deleteById(String.valueOf(student.getId()));
        studentMySqlRepo.save(student);
    }

    public Student findById(String id) {
        //该对象用来缓存空数据
        Student empStudent = new Student();
        empStudent.setId(-1L);

        Random random = new Random();
        Student student = studentRedisDao.findById(String.valueOf(id));

        if (student != null) {
            System.out.println("Get student from redis");
            if (student.getId() != -1L) {
                return student;
            }
            return null;
        }
        System.out.println("Get student from MySQL");
        student = studentMySqlRepo.findStudentById(Long.valueOf(id));
        int randNum = random.nextInt(100);
        if (student != null) {
            studentRedisDao.saveStudent(id, 24 * 60 * 60 + randNum, student);
            return student;
        } else {
            studentRedisDao.saveStudent(id, 24 * 60 * 60 + randNum, empStudent);
            return null;
        }
    }

    public void deleteById(String id) {
        studentRedisDao.deleteById(id);
        studentMySqlRepo.deleteById(Long.valueOf(id));
    }
}
