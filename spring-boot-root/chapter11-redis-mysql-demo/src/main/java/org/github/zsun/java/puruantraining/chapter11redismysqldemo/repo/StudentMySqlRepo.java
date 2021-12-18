package org.github.zsun.java.puruantraining.chapter11redismysqldemo.repo;

import org.github.zsun.java.puruantraining.chapter11redismysqldemo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMySqlRepo extends JpaRepository<Student, Long> {
    Student findStudentById(Long id);
}
