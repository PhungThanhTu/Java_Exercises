package CustomExceptions;

public class InvalidInputException extends Exception{
    public InvalidInputException( Throwable cause) {
        super("Invalid Input from user");
    }
}
