package petri.net;

public class ElementDoNotExistException extends Exception {
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    private void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ElementDoNotExistException(String errorMessage){
        this.setErrorMessage(errorMessage);
    }

}
