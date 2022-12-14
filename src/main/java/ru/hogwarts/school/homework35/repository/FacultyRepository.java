package ru.hogwarts.school.homework35.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hogwarts.school.homework35.model.Faculty;
import java.util.List;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    List<Faculty> getFacultiesByColor(String color);

    Faculty findByNameIgnoreCaseOrColorIgnoreCase(String name, String color);

}
