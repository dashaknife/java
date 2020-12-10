package exception;

public class WrongInputException extends RuntimeException{
    public WrongInputException(String message){
        super(message);
    }

    @Override
    public String toString() {
        return "My exception: " + super.getMessage();
    }
}
