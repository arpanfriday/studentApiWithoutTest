package com.example.studentapi;

import com.example.studentapi.student.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class StudentApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentApiApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(StudentRepository studentRepository, MongoTemplate mongoTemplate) {
//        return args -> {
//            String email = "david@gmail.com";
//            Student student = new Student(
//                    "David Prasad",
//                    1000012353L,
//                    email,
//                    LocalDate.of(1995, 07, 20)
//            );
////            usingMongoTemplateAndQuery(studentRepository, mongoTemplate, email, student);
//        };
        return null;
    }

//    private void usingMongoTemplateAndQuery(StudentRepository studentRepository, MongoTemplate mongoTemplate, String email, Student student) {
//        Query query = new Query();
//        query.addCriteria(Criteria.where("email").in(email));
//        List<Student> students = mongoTemplate.find(query, Student.class);
//        if(students.size() > 1){
//            throw new IllegalStateException(
//                    "found many students with email " + email
//            );
//        }
//        if(students.isEmpty ()) {
//            System.out.println("Inserting student " + student);
//            studentRepository.insert(student);
//        } else {
//            System.out.println(student + " already exists");
//        }
//    }
}
