package exception;

/**
 * @author tianpanke
 * @title: MyException
 * @projectName Test
 * @description: TODO
 * @date 2019/8/1 14:32
 */
public enum  MyException implements IException {
    MEMBER_NO_LOGIN(1000,"会员没登录");
    private int code;
    private String message;

    MyException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }
    @Override
    public String getMessage() {
        return message;
    }

    public void setCode(int code) {
        this.code = code;
    }}
