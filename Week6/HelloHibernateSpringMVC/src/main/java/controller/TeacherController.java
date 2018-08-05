package controller;

import model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.TeacherService;

import java.util.List;

/**
 * Created by CoT on 7/29/18.
 */
@RestController
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping(path = "teachers", method = RequestMethod.GET)
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @RequestMapping(path = "teachers", method = RequestMethod.POST)
    public String addTeacher(@RequestBody Teacher teacher) {
        teacherService.saveTeacher(teacher);
        return "Teacher id " + teacher.getId() + " added";
    }

    @RequestMapping(path = "teachers/{id}", method = RequestMethod.DELETE)
    public String deleteTeacher(@PathVariable int id) {
        teacherService.deleteTeacher(id);
        return "Teacher id " + id + " deleted";
    }

    @RequestMapping(path = "teachers", method = RequestMethod.PUT)
    public String updateTeacher(@RequestBody Teacher teacher) {
        teacherService.updateTeacher(teacher);
        return "Teacher id " + teacher.getId() + " updated";
    }
}
