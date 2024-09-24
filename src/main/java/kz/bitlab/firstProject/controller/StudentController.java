package kz.bitlab.firstProject.controller;

import kz.bitlab.firstProject.model.City;
import kz.bitlab.firstProject.model.Student;
import kz.bitlab.firstProject.model.Subject;
import kz.bitlab.firstProject.repository.CityRepository;
import kz.bitlab.firstProject.repository.SubjectRepository;
import kz.bitlab.firstProject.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private StudentServiceImpl studentService;

    @GetMapping(value = "/")
    public String home(Model model) {
        model.addAttribute("list", studentService.getAllStudents());
        model.addAttribute("cities", cityRepository.findAll());
        return "main2";
    }

    @PostMapping(value = "/add-student")
    public String addStudent(Student student) {
        studentService.addStudent(student);
        return "redirect:/student/";
    }

    @GetMapping(value = "/add-student")
    public String addStudentPage(Model model) {
        model.addAttribute("cities", cityRepository.findAll());
        return "add-student";
    }

    @GetMapping(value = "/student-details/{id}")
    public String studentDetails(@PathVariable int id, Model model) {
        var student = studentService.getStudentById(id);
        var subjects = subjectRepository.findAll();

        subjects.removeAll(student.getSubjects());

        model.addAttribute("subjects", subjects);
        model.addAttribute("cities", cityRepository.findAll());
        model.addAttribute("student", studentService.getStudentById(id));
        return "student-details";
    }

    @PostMapping(value = "/update-student")
    public String updateStudent(Student student) {
        studentService.updateStudent(student);
        return "redirect:/student/";
    }

    @PostMapping(value = "/delete-student")
    public String deleteStudent(int id) {
        studentService.deleteStudentById(id);
        return "redirect:/student/";
    }

    @GetMapping("/search")
    public String search(@RequestParam String search, Model model) {
        model.addAttribute("list", studentService.searchByWord(search));
        return "main2";
    }

    @PostMapping(value = "/delete-subject")
    public String deleteSubject(@RequestParam int subject_id,
                                @RequestParam int student_id) {

        Subject subject = subjectRepository.findById(subject_id).orElseThrow();
        Student student = studentService.getStudentById(student_id);

        student.getSubjects().remove(subject);

        studentService.updateStudent(student);

        return "redirect:/student/student-details/" + student_id;
    }

    @PostMapping(value = "/add-subject")
    public String addSubject(@RequestParam int subject_id,
                                @RequestParam int student_id) {

        Subject subject = subjectRepository.findById(subject_id).orElseThrow();
        Student student = studentService.getStudentById(student_id);

        student.getSubjects().add(subject);

        studentService.updateStudent(student);

        return "redirect:/student/student-details/" + student_id;
    }
}
