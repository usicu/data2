package cn.edu.ctbu.data.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity(name="tb_student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "学号不能为空")
    @Size(min=10,max=10,message = "学号必须是10位")
    private String no;
    @NotNull(message = "姓名不能为空")
    @Size(min=2,max=10,message = "名字长度在2-10字符之间")
    private String name;
    private String password;
    private String sex;
    private Integer age;
    private Integer score;

}
