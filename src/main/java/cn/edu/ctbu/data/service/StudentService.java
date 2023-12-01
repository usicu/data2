package cn.edu.ctbu.data.service;

import cn.edu.ctbu.data.domain.Student;
import cn.edu.ctbu.data.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;


    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    /**
     * id进行查询按
     * @param id，主键
     * @return
     */
    public Student getById(Integer id){

        return studentRepository.findById(id).orElse(null);
    }

//    public List<Student> findByName1(String name){
//
//        return (List<Student>) studentRepository.getmaxage();
//    }


    /**
     * 按名字进行查询按
     * @param name
     * @return
     */
    public List<Student> findByName(String name){

        return studentRepository.findByNameLike(name);
    }

    /**
     * 按名字和密码进行查询按
     * @param name
     * @param password
     * @return
     */
    public List<Student> findByNameAndPassword(String name,String password){

        return studentRepository.findByNameAndPassword(name,password);
    }

    public Student Insert(Student student){
        studentRepository.save(student);
        return student;
    }


    public Student update(Student student){
        studentRepository.save(student);
        return student;
    }

    public void delete(Student student){
        studentRepository.delete(student);
//        return student;
    }
    public void delete(Integer id){
        Student student=new Student();
        student.setId(id);

        studentRepository.delete(student);
    }


    public Student getmaxno() {
        return  studentRepository.getmaxno();
    }
}
