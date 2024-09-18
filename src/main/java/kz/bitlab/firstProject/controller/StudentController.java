package kz.bitlab.firstProject.controller;

import kz.bitlab.firstProject.model.Student;
import kz.bitlab.firstProject.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @GetMapping(value = "/")
    public String home(Model model) {
        model.addAttribute("list", studentService.getAllStudents());
        return "main2";
    }

    @PostMapping(value = "/add-student")
    public String addStudent(Student student) {
        studentService.addStudent(student);
        return "redirect:/student/";
    }

    @GetMapping(value = "/add-student")
    public String addStudentPage() {
        return "add-student";
    }

    @GetMapping(value = "/student-details/{id}")
    public String studentDetails(@PathVariable int id, Model model) {
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
}
