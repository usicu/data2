package cn.edu.ctbu.data.core;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PageUntils implements Serializable {
    private static final long serialVertionUID = 1L;
    private int total;
    private List<?> rows;

    public PageUntils(List<?> list, Long total){
        this.rows=list;
        this.total=total.intValue();
    }

    public PageUntils(List<?> list, int total){
        this.rows=list;
        this.total=total;
    }
}