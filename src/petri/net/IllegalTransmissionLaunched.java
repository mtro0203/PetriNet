package petri.net;

public class IllegalTransmissionLaunched extends Exception {

    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    private void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public IllegalTransmissionLaunched(String errorMessage){
        this.setErrorMessage(errorMessage);
    }


}
