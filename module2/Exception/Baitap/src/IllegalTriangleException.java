public class IllegalTriangleException extends Throwable {
    private String message;

    public IllegalTriangleException() {
    }

    public IllegalTriangleException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}