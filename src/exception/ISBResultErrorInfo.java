package exception;

import java.io.Serializable;
import java.util.List;

/**
 * @author tianpanke
 * @title: ISBResultErrorInfo
 * @projectName Test
 * @description:
 * @date 2019/8/1 14:26
 */
public class ISBResultErrorInfo implements Serializable {
    public ISBResultErrorInfo() {
    }

    public ISBResultErrorInfo(String code, String message) {
        super();
        this.errorCode = code;
        this.message = message;
    }

    public ISBResultErrorInfo(String code, String message, String errorStack) {
        this.errorCode = code;
        this.errorStack =errorStack;
        this.message = message;
    }

    public ISBResultErrorInfo(String code, String message, List<String> messageStacks) {
        super();
        this.errorCode = code;
        this.message = message;
        if(messageStacks!=null){
            this.messageStacks=messageStacks;
        }
        this.messageStacks.add(0,message);
    }

    private String errorCode;


    private String message = null;


    private String errorStack = null;


    private List<String> messageStacks=null;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorStack() {
        return errorStack;
    }

    public void setErrorStack(String errorStack) {
        this.errorStack = errorStack;
    }

    public List<String> getMessageStacks() {
        return messageStacks;
    }

    public void setMessageStacks(List<String> messageStacks) {
        this.messageStacks = messageStacks;
    }
}
