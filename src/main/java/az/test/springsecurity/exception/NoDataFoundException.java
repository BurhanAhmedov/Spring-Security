package az.test.springsecurity.exception;

public class NoDataFoundException extends RuntimeException{
  public NoDataFoundException(String message){
    super(message);
  }

}
