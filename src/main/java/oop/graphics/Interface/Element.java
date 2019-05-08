package oop.graphics.Interface;

public interface Element extends Drawable {

     long getId();
     void onRun();

     void onClick(float x , float y);
}
