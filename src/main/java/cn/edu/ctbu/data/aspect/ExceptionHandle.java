package cn.edu.ctbu.data.aspect;


import cn.edu.ctbu.data.exception.RException;
import cn.edu.ctbu.data.utils.RUtil;
import cn.edu.ctbu.data.vo.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    public R handle(Exception e){
        if(e instanceof RException) {
            RException rException=(RException) e;
            return RUtil.error(rException.getCode(),rException.getMessage());
        }
        return RUtil.error(-999,e.getMessage());
    }


}
