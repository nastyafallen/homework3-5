package ru.hogwarts.school.homework35.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.homework35.service.FacultyService;
import ru.hogwarts.school.homework35.model.Faculty;
import ru.hogwarts.school.homework35.model.Student;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public ResponseEntity<Faculty> createFaculty(@RequestBody Faculty faculty) {
        Faculty newFaculty = facultyService.createFaculty(faculty);
        return ResponseEntity.ok(newFaculty);
    }

    @GetMapping("/find")
    public ResponseEntity<Faculty> getFaculty(@RequestParam("id") Long id) {
        Optional<Faculty> faculty = facultyService.getFaculty(id);
        if (faculty.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty.get());
    }

    @PutMapping
    public ResponseEntity<Faculty> updateFaculty(@RequestBody Faculty faculty) {
        Faculty updatedFaculty = facultyService.updateFaculty(faculty.getId(), faculty);
        return ResponseEntity.ok(updatedFaculty);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteFaculty(@PathVariable Long id) {
        facultyService.deleteFaculty(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{color}")
    public List<Faculty> getFacultiesByColor(@PathVariable String color) {
        return facultyService.getFacultiesByColor(color);
    }

    @GetMapping
    public ResponseEntity<Faculty> findByNameOrColor(@RequestParam("value") String name) {
        return ResponseEntity.ok(facultyService.findByNameOrColor(name));
    }

    @GetMapping("/{id}/students")
    public Set<Student> getStudentsById(@PathVariable Long id) {
        return facultyService.getStudentsById(id);
    }
}

