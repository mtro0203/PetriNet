package oop.petriNet.exceptions;

public class GraphicsExeption extends Exception {
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    private void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public GraphicsExeption(String errorMessage){
        this.setErrorMessage(errorMessage);
    }
}
