package ar.com.kfgodel.asql.api;

/**
 * This type represents an error on the asql processing
 * Created by kfgodel on 12/07/15.
 */
public class AsqlException extends RuntimeException {

    public AsqlException(String message) {
        super(message);
    }

    public AsqlException(String message, Throwable cause) {
        super(message, cause);
    }

    public AsqlException(Throwable cause) {
        super(cause);
    }
}
