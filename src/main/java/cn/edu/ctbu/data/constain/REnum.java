package cn.edu.ctbu.data.constain;

public enum REnum {

    UNKOWN_ERR(-999,"未知错误"),
    COMMON_ERR(-10,"一般性错误2"),
    LOGIN_ERR(-2,"出错，不正确，不正确的用户名称或密码！！"),
    SUCCESS(1,"成功");

    private Integer code;
    private String msg;
    REnum(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public Integer getCode(){
        return code;
    }

    public String getMsg(){
        return msg;
    }

}
