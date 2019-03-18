package petri.net;

public abstract class BaseElement {

    private long id;
    private String name;

    protected BaseElement(long id, String name) {
        this.id = id;
        this.name = name;
    }


    public abstract int getTokens();
    public abstract void receiveTokens(int count);
    public abstract void takeTokens(int count) throws IllegalTransmissionLaunched;


}
