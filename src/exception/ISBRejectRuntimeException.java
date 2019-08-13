package exception;

import org.apache.commons.lang3.exception.ExceptionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tianpanke
 * @title: ISBRejectRuntimeException
 * @projectName Test
 * @description: 拒绝服务异常
 * @date 2019/8/1 13:54
 */
public class ISBRejectRuntimeException extends RuntimeException {

    private String errorCode; //异常编码

    private String message=null;//异常信息

    private String errorStacks=null;//异常堆栈

    private List<String> messageStacks=new ArrayList<>();//跟踪异常信息

    public ISBRejectRuntimeException(String message) {
        super(message);
        this.errorCode=ExceptionConst.REJECT_ERROR_CODE;
        this.message=message;
    }
    public ISBRejectRuntimeException(String errorCode,String message) {
        super(message);
        this.errorCode=errorCode;
        this.message=message;
    }
    public ISBRejectRuntimeException(String errorCode,String message,List<String> messageStacks) {
        super(message);
        this.errorCode=errorCode;
        this.message=message;
        if(messageStacks!=null)
            this.messageStacks=messageStacks;
        this.messageStacks.add(0,message);
    }
    public ISBRejectRuntimeException(String code, String message, Throwable t) {
        super(message, t);
        this.errorCode = code;
        this.message = message;
        if (t != null) {
            this.errorStacks = ExceptionUtils.getStackTrace(t);
        }
    }
    public ISBRejectRuntimeException(String message, Throwable t) {
        super(message, t);
        this.errorCode = ExceptionConst.REJECT_ERROR_CODE;
        this.message = message;
        if (t != null) {
            this.errorStacks = ExceptionUtils.getStackTrace(t);
        }
    }
    public ISBRejectRuntimeException(ISBResultErrorInfo isbResultErrorInfo){
        super("");
        if(isbResultErrorInfo.getMessageStacks()!=null){
            this.messageStacks=isbResultErrorInfo.getMessageStacks();
        }
    }
    public ISBRejectRuntimeException(String message, ISBResultErrorInfo isbResultErrorInfo){
        super(message);
        if(isbResultErrorInfo.getMessageStacks()!=null){
            this.messageStacks=isbResultErrorInfo.getMessageStacks();
        }
    }
    public List<String> getMessageStacks() {
        return messageStacks;
    }

    public String getErrorCode() {
        return errorCode;
    }

}
