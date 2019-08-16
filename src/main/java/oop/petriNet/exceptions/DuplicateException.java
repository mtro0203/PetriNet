package oop.petriNet.exceptions;

public class DuplicateException extends Exception {
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    private void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public DuplicateException(String errorMessage){
        this.setErrorMessage(errorMessage);
    }

}
