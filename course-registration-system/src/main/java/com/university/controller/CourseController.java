package com.university.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.university.dao.CourseDAO;
import com.university.dao.RegistrationDAO;
import com.university.model.Course;
import com.university.model.Student;

@Controller
public class CourseController {

    @Autowired
    private CourseDAO courseDAO;

    @Autowired
    private RegistrationDAO registrationDAO;

    @GetMapping("/courses")
    public String showCourses(Model model) {
        List<Course> courses = courseDAO.getAllCourses();
        model.addAttribute("courses", courses);
        return "courses";
    }

    @PostMapping("/register/{courseId}")
    public String registerCourse(@PathVariable("courseId") int courseId, HttpSession session, Model model) {
        Student student = (Student) session.getAttribute("student");
        if (student == null) {
            return "redirect:/login";
        }

        boolean success = registrationDAO.registerStudentToCourse(student.getId(), courseId);
        if (success) {
            model.addAttribute("message", "Registration successful!");
        } else {
            model.addAttribute("message", "You are already registered for this course.");
        }

        return "success";
    }
}
