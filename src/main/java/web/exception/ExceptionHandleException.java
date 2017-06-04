package web.exception;

/**
 * Created by Liuqi
 * Date: 2017/5/8.
 */
public class ExceptionHandleException extends Exception{

    public ExceptionHandleException(String message) {
        super(message);
    }

    public ExceptionHandleException(String message, Throwable cause) {
        super(message, cause);
    }
}
