package petri.net;

import com.sun.javaws.exceptions.InvalidArgumentException;

public abstract class BaseEdge<T extends BaseElement> {


    protected BaseEdge(T startElement,BaseElement endElement) {

        this.setStartElement(startElement);
        this.setEndElement(endElement);
    }

    private  T startElement;

    public T getStartElement() { return startElement; }

    public void setStartElement(T startElement) {
       this.startElement = startElement;
    }

    private BaseElement endElement;

    public BaseElement getEndElement() {
        return endElement;
    }

    public void setEndElement(BaseElement endElement) {

        if (getStartElement().getClass() == endElement.getClass())
            throw new IllegalArgumentException("Hrana sa neda vytvorit medzi dvoma vyrcholmi rovnakeho typu");

        this.endElement = endElement;
    }

    public abstract void run() throws IllegalTransmissionLaunchedException;


}
