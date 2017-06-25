package ua.itemstore.exceptions;

/**
 * Created by xnx_ on 24.06.2017.
 */
public class ByMoreThenExistItemException extends RuntimeException {
    public ByMoreThenExistItemException() {
    }

    public ByMoreThenExistItemException(String message) {
        super(message);
    }

    public ByMoreThenExistItemException(String message, Throwable cause) {
        super(message, cause);
    }

    public ByMoreThenExistItemException(Throwable cause) {
        super(cause);
    }

    public ByMoreThenExistItemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
