package array.exception;

public class CustomArrayException extends Exception {

    public CustomArrayException(){
        super();
    }

    public CustomArrayException (String message) {
        super(message);
        message.toString();
    }

    public  CustomArrayException (Throwable cause){
        super(cause);
    }

    public CustomArrayException (String message, Throwable cause) {
        super(message, cause);
    }
}
