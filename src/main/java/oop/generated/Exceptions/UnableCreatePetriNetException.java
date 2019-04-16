package oop.generated.Exceptions;

public class UnableCreatePetriNetException extends Exception {

    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    private void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public UnableCreatePetriNetException(String errorMessage){
        this.setErrorMessage(errorMessage);
    }
}
