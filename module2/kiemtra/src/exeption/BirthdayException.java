package exeption;

import org.omg.CORBA.UserException;


public class BirthdayException extends UserException {
    public BirthdayException() {
    }

    public BirthdayException(String message) {
        super(message);
    }

}
