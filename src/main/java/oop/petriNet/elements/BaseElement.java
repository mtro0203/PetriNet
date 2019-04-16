package oop.petriNet.elements;

public abstract class BaseElement {

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    private long id;
    private String name;

    private float x = -1;
    private float y = -1;

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }


    public BaseElement(long id, String name, float x, float y) {
        this.id = id;
        this.name = name;
        this.x = x;
        this.y = y;
    }

    protected BaseElement(long id, String name) {
        this.id = id;
        this.name = name;

    }










}
