package oop.petriNet.Interface;

import oop.graphics.Interface.NetCanvas;

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

    void clearNet();
}
