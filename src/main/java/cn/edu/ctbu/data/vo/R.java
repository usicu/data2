package cn.edu.ctbu.data.vo;

import lombok.Data;

/**
 * 通用返回对象
 * @param <T>
 */
@Data
public class R<T> {
    private Integer code;
    private String msg;
    private T data;

}
