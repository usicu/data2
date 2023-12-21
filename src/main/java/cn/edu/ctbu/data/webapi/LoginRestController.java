package cn.edu.ctbu.data.webapi;

import cn.edu.ctbu.data.domain.Student;
import cn.edu.ctbu.data.service.StudentService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/webapi/login")
public class LoginRestController {
    @Autowired
    StudentService studentService;

    @GetMapping("/user")
    public int user(HttpServletRequest httpServletRequest,String username,String password){
        List<Student> students=studentService.findByNameAndPassword(username,password);

        if(students.size()>0){
            HttpSession session=httpServletRequest.getSession();
            session.setAttribute("userid",students.get(0).getId());

            session.setAttribute("user",students.get(0));

            return 1;
        }else {
            return -1;
        }

    }

}
