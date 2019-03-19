package petri.net;

public abstract class BaseElement {

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    private long id;
    private String name;

    protected BaseElement(long id, String name) {
        this.id = id;
        this.name = name;
    }






}
