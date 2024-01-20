package sb.OnlineFoodDeliverySystem.exception;

public class UsernameIsCorrectPasswordException extends RuntimeException{

    public UsernameIsCorrectPasswordException(String msg) {
        super(msg);
    }
}
