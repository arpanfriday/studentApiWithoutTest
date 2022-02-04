package com.example.studentapi.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {

        studentRepository.findById(student.getId()).ifPresentOrElse(student1 -> {
                    throw new IllegalStateException(student1.getId() + " already exists");
                },
                () -> {
                    if (studentRepository.findStudentByEmail(student.getEmail()).isPresent()) {
                        throw new IllegalStateException("Student with same email id not possible");
                    } else {
                        System.out.println("Inserting student " + student);
                        studentRepository.insert(student);
                    }
                });
    }

    public Optional<Student> getStudentById(String id) {
        return studentRepository.findById(id);
    }

    public void updateStudent(String id, Student student) {
        student.setId(id);
        studentRepository.save(student);
    }

    public void deleteStudent(String id) {
        if(!studentRepository.existsById(id)){
            throw new IllegalStateException("No element present with ID " + id);
        }
        studentRepository.deleteById(id);
    }
}
