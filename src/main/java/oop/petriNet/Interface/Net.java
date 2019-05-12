package oop.petriNet.Interface;

import oop.graphics.Interface.NetCanvas;
import oop.petriNet.elements.BaseElement;
import oop.petriNet.elements.Place;
import oop.petriNet.elements.Transition;

import java.util.List;

public interface Net {
    void createGraphics(NetCanvas canvas);
    void createTransition(String name,float x , float y);
    void createPlace( String name, int startTokens,float x, float y);

    void createTransition(long id,String name,float x , float y);
    void createPlace(long id, String name, int startTokens,float x, float y);


    void createRessetEdge(long startPlaceId, long endTransitionId);
    void createEdge(long startId, long endId, int multiplicity);
    void createRessetEdge(long startPlaceId, long endTransitionId,long id);
    void createEdge(long startId, long endId, int multiplicity, long id);

    void addToken(long id, int count);
    void removeElement(long id);
    <T extends BaseElement> List<T> getElements(Class<T> type);
    void setMultiplicity(long id, int multi);
    void run (long id);

    void clearNet();
}
