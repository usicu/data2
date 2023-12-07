package cn.edu.ctbu.data.webapi;

import cn.edu.ctbu.data.core.PageUntils;
import cn.edu.ctbu.data.domain.Student;
import cn.edu.ctbu.data.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@RestController
@RequestMapping("/webapi/student")

public class StudentRestController {

    @Autowired
    private StudentService studentService;

    /**
     * 读取的url：/webapi/student/list
     * @return
     */
    @GetMapping("/list")
    public List<Student> getAll(){
        List<Student> students=studentService.findAll();
        return students;
    }

    /**
     * 分页，读取全部内容
     * @return
     */
    @GetMapping("/getbypage")
    public PageUntils getByPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                @RequestParam(value = "size", defaultValue = "10") Integer size,
                                @RequestParam(value = "name",defaultValue = "")String name){

        /**
         * 按id排序
         */
        Sort sort=Sort.by(Sort.Direction.DESC,"id");

        Page<Student> studentPage;
        if(StringUtils.isEmpty(name)){
            Pageable pageable= PageRequest.of(page,size,sort);
            studentPage = studentService.findAll(pageable);
        }else{
            Student student=new Student();
            student.setName(name);
            Pageable pageable=PageRequest.of(0,10,sort);
            ExampleMatcher matcher=ExampleMatcher.matching()
                    .withMatcher("name",ExampleMatcher.GenericPropertyMatchers.contains());
            Example<Student> example = Example.of(student,matcher);
            studentPage = studentService.findAll(example,pageable);
        }
        PageUntils pageUntils=new PageUntils(studentPage.getContent(),studentPage.getTotalElements());
        return pageUntils;
    }

    /**
     * 读取的url：/webapi/student/get/id
     * @return
     */
    @GetMapping("/get/{id}")
    public Student get(@PathVariable Integer id){
        Student student=studentService.getById(id);
        student.setPassword("");
        return student;
    }

    /**
     * 新增
     * @param student
     * @return
     */
    @PostMapping("/insert")
    public Student insert(Student student){
        Student student1=studentService.Insert(student);
        return student1;
    }

    /**
     * 更新
     * @param student
     * @return
     */
    @PutMapping("/update")
    public Student update(Student student){
        //读取旧数据
        Student oldstudent=studentService.getById(student.getId());
        if(StringUtils.isEmpty(student.getPassword())){
            //没有新密码，那么就是旧密码
            student.setPassword(oldstudent.getPassword());
        }
        student=studentService.update(student);
        return student;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public void  delete(@PathVariable Integer id){
        studentService.delete(id);
//        return student1;
    }

}
