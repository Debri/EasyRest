package web.exception;

/**
 * Created by Liuqi
 * Date: 2017/4/28.
 */
public class ConfigurationException extends Exception{
    public ConfigurationException(String message) {
        super(message);
    }

    public ConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }
}
