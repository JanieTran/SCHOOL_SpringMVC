package controller;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.StudentService;

import java.util.List;

/**
 * Created by CoT on 7/29/18.
 */
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(path = "students", method = RequestMethod.GET)
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @RequestMapping(path = "students", method = RequestMethod.POST)
    public String addStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return "Student id " + student.getId() + " added";
    }

    @RequestMapping(path = "students/{id}", method = RequestMethod.DELETE)
    public String deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return "Student id " + id + " deleted";
    }

    @RequestMapping(path = "students", method = RequestMethod.PUT)
    public String updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
        return "Student id " + student.getId() + " updated";
    }
}
