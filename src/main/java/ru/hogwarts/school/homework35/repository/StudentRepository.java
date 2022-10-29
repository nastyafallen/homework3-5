package ru.hogwarts.school.homework35.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hogwarts.school.homework35.model.Student;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> getStudentsByAge(int age);

    List<Student> findByAgeBetween(int min, int max);

    Optional<Student> findStudentById(Long id);

}
