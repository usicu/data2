package cn.edu.ctbu.data.repository;

import cn.edu.ctbu.data.domain.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;


public interface StudentRepository extends JpaRepository<Student,Integer> {
    /**
     * 按名字查询
     * @param name
     * @return
     */
    List<Student> findByNameLike(String name);

    /**
     * 按名字和密码查询
     * @param name
     * @param password
     * @return
     */
    List<Student> findByNameAndPassword(String name,String password);


    public List<Student> findByno(String no);

}

