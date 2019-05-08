package oop.petriNet.Interface;

import oop.graphics.Interface.NetCanvas;

public interface Net {
    void createGraphics(NetCanvas canvas);
    void createTransition(int id, String name,float x , float y);
    void createPlace(long id, String name, int startTokens,float x, float y);


    void createRessetEdge(long startPlaceId, long endTransitionId,long id);
    void createEdge(long startId, long endId, int multiplicity,long id);


    void clearNet();
}
