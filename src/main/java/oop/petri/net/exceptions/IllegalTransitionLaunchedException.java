package oop.petri.net.exceptions;

public class IllegalTransitionLaunchedException extends Exception {


    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    private void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    private void setErrorMessage(String errorMessage,long id) {
        this.errorMessage = errorMessage + "  {Id " +id + " }";
    }

    public IllegalTransitionLaunchedException(String errorMessage){
        this.setErrorMessage(errorMessage);
    }

    public IllegalTransitionLaunchedException(String errorMessage,long id){
        this.setErrorMessage(errorMessage, id);
    }


}
