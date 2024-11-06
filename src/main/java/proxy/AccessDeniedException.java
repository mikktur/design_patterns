package proxy;

public class AccessDeniedException extends RuntimeException {
    public AccessDeniedException() {
        super("Access Denied");
    }
}
