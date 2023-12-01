package cn.edu.ctbu.data.controller;

import org.springframework.ui.Model;
//import ch.qos.logback.core.model.Model;
import cn.edu.ctbu.data.domain.Student;
import cn.edu.ctbu.data.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping("/student/list")
    public String list(Model model){

        List<Student> students=studentService.findAll();

        model.addAttribute("data",students);


        return "/student/list";
    }

}
