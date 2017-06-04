package web.exception;


/**
 * Created by Liuqi
 * Date: 2017/5/8.
 */
public class UrlDuplicatedException extends Exception{
    public UrlDuplicatedException(String message) {
        super(message);
    }

    public UrlDuplicatedException(String message, Throwable cause) {
        super(message, cause);
    }
}
