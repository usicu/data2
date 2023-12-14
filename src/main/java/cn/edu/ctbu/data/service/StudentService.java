package cn.edu.ctbu.data.service;

import cn.edu.ctbu.data.domain.Student;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {


    List<Student> findAll();

    /**
     * 只分页差询
     *
     * @param pageable
     * @return
     */
    Page<Student> findAll(Pageable pageable);

    /**
     * 分页，带过滤的查询
     */
    public Page<Student> findAll(Example<Student> student, Pageable pageable);


    /**
     * id进行查询按
     *
     * @param id，主键
     * @return
     */
    Student getById(Integer id);

//    public List<Student> findByName1(String name){
//
//        return (List<Student>) studentRepository.getmaxage();
//    }


    /**
     * 按名字进行查询按
     *
     * @param name
     * @return
     */
    List<Student> findByName(String name);

    /**
     * 按名字和密码进行查询按
     *
     * @param name
     * @param password
     * @return
     */
    List<Student> findByNameAndPassword(String name, String password);

    Student Insert(Student student);


    Student update(Student student);

    void delete(Student student);

    void delete(Integer id);


    Student add(Student student);
    public Student insert(Student student);
}
