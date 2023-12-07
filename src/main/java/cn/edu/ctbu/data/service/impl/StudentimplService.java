package cn.edu.ctbu.data.service.impl;

import cn.edu.ctbu.data.domain.Student;
import cn.edu.ctbu.data.repository.StudentRepository;
import cn.edu.ctbu.data.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentimplService implements StudentService {
    @Autowired
    private StudentRepository studentRepository;


    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    /**
     * 只分页差询
     * @param pageable
     * @return
     */
    public Page<Student> findAll(Pageable pageable){
        return studentRepository.findAll(pageable);
    };

    /**
     * 分页，带过滤的查询
     */
    public  Page<Student> findAll(Example<Student> student, Pageable pageable){
        return studentRepository.findAll(student,pageable);
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



}
