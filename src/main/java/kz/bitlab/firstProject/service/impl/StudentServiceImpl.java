package kz.bitlab.firstProject.service.impl;

import kz.bitlab.firstProject.model.Student;
import kz.bitlab.firstProject.repository.StudentRepository;
import kz.bitlab.firstProject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Override
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public void updateStudent(Student student) {
        repository.save(student);
    }

    @Override
    public void deleteStudentById(int id) {
        repository.deleteById(id);
    }

    @Override
    public void addStudent(Student student) {
        repository.save(student);
    }

    public List searchByWord(String search) {
        return repository.getAllStudentsByWord(search);
    }
}
