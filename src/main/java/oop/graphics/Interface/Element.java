package oop.graphics.Interface;

public interface Element extends Drawable {

     long getId();
     void runMode();


     void run();
     boolean isClicked(float x , float y);
}
