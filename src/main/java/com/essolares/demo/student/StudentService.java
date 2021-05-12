package com.essolares.demo.student;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
		return studentRepository.findAll();
	}

    public void addNewStudent(Student student) {
        Optional<Student> studentFinded = 
        studentRepository.findStudentByEmail(student.getEmail());
        if (studentFinded.isPresent()){
            throw new IllegalStateException("Emal taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)){
            throw new IllegalThreadStateException("Can't delete student " + id);
        }
        studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(Long id, String name, String email) {
        Student student = studentRepository.findById(id)
            .orElseThrow(() -> 
                new IllegalStateException("Student "+ id + "don't exist")
            );
        if (name != null && name.length() > 0 
        && !Objects.equals(student.getName(), name)){
            student.setName(name);
        }
        if (email != null && email.length() > 0 
        && !Objects.equals(student.getEmail(), email)){
            Optional<Student> tempStudent = studentRepository.findStudentByEmail(email);
            if (tempStudent.isPresent()){
                throw new IllegalStateException("Email taken");
            }
            student.setEmail(email);
        }


    }

}
