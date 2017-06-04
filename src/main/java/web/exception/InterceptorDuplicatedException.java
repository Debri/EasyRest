package web.exception;

/**
 * Created by Liuqi
 * Date: 2017/5/8.
 */
public class InterceptorDuplicatedException extends Exception{
    public InterceptorDuplicatedException(String message) {
        super(message);
    }

    public InterceptorDuplicatedException(String message, Throwable cause) {
        super(message, cause);
    }
}
