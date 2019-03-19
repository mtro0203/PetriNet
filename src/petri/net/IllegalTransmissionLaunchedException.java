package petri.net;

public class IllegalTransmissionLaunchedException extends Exception {

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

    public IllegalTransmissionLaunchedException(String errorMessage){
        this.setErrorMessage(errorMessage);
    }

    public IllegalTransmissionLaunchedException(String errorMessage,long id){
        this.setErrorMessage(errorMessage, id);
    }


}
