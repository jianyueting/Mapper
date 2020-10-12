package tk.mybatis.mapper;

/**
 * created at 2020/10/12 10:15
 *
 * @author jeff
 */
public class LikeTypeException extends RuntimeException {
    public LikeTypeException(String message) {
        super(message);
    }

    public LikeTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public LikeTypeException(Throwable cause) {
        super(cause);
    }

    public LikeTypeException() {
    }
}
