package exception;

/**
 * @author tianpanke
 * @title: IException
 * @projectName Test
 * @description:
 * @date 2019/8/1 14:29
 */
public interface IException {
    String MESSAGE_PREFIX = "@@@";

    /**
     * 获取错误码
     * @return
     */
    int getCode();

    /**
     * 获取错误信息
     * @return
     */
    String getMessage();

    /**
     * 获取异常
     * @return
     */
    /**
     * 获取异常
     * @return
     */
    default ISBRejectRuntimeException get(){
        return new ISBRejectRuntimeException(String.valueOf(getCode()),MESSAGE_PREFIX+getMessage());
    }

    /**
     * 获取异常(支持e)
     * @param e
     * @return
     */
    default ISBRejectRuntimeException get(Exception e){
        return new ISBRejectRuntimeException(String.valueOf(getCode()),MESSAGE_PREFIX+getMessage(),e);
    }
}
