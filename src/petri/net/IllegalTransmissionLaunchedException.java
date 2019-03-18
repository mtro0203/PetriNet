package petri.net;

public class IllegalTransmissionLaunchedException extends Exception {

    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    private void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public IllegalTransmissionLaunchedException(String errorMessage){
        this.setErrorMessage(errorMessage);
    }


}
