package cn.edu.ctbu.data.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name="tb_student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    /*
     * 学号
     */
    private String no;

    /*
     * 姓名
     */
    private String name;

    /*
     * 密码
     */
    private String password;

    /*
     * 性别,0未知,1男,2女
     */
    private Integer sex;

    /*
     * 年龄
     */
    private Integer age;

    /*
     * 成绩
     */
    private Integer score;
}