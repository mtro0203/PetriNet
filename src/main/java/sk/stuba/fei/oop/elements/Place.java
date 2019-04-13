package petri.net;

public class Place extends BaseElement {

    private int tokens;

    protected Place(long id, String name, int tokens) {
        super(id, name);
       setTokens(tokens);
    }


    public int getTokens() {
        return tokens;
    }

    public void setTokens(int tokens) {
       if(tokens<0)
           throw new IllegalArgumentException("V mieste nemoze byt zaporny pocet tokenov");

       this.tokens = tokens;
    }


    public void receiveTokens(int count) {
        setTokens(this.getTokens()+count);
    }


    public void takeTokens(int count) throws IllegalTransitionLaunchedException {
        if(this.getTokens() < count)
            throw new IllegalTransitionLaunchedException("Tento prechod nieje mozne spustit");

        setTokens(getTokens()-count);
    }

    public String getInfo(){
        return "Miesto s id " + getId() + " ma " + getTokens() + " tokenov";
    }
}
