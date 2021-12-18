package org.github.zsun.java.puruantraining.chapter11redismysqldemo.repo;

import com.google.gson.Gson;
import org.github.zsun.java.puruantraining.chapter11redismysqldemo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
public class StudentRedisDao {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void saveStudent(String id, int expireTime, Student student) {
        Gson gson = new Gson();
        redisTemplate.opsForValue().set(id, gson.toJson(student), expireTime, TimeUnit.SECONDS);
    }

    public Student findById(String id) {
        Gson gson = new Gson();
        Student student = null;
        String studentJson = redisTemplate.opsForValue().get(id);
        if (studentJson != null && !"".equals(studentJson)) {
            student = gson.fromJson(studentJson, Student.class);
        }
        return student;
    }

    public void deleteById(String id) {
        redisTemplate.opsForValue().getOperations().delete(id);
    }
}