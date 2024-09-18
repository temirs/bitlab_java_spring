package kz.bitlab.firstProject.service;

import kz.bitlab.firstProject.model.Student;


import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    Student getStudentById(int id);

    void updateStudent(Student student);

    void deleteStudentById(int id);

    void addStudent(Student student);

    List<Student> searchByWord(String search);
}
