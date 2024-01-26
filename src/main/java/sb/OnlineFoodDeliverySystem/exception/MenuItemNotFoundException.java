package sb.OnlineFoodDeliverySystem.exception;


public class MenuItemNotFoundException extends RuntimeException {
    public MenuItemNotFoundException(String s) {
        super(s);
    }
}
