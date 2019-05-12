package oop.graphics.Interface;

public interface Element extends Drawable {

     long getId();
     void runMode(boolean param);

     void clicked(boolean param);
     boolean isClicked(float x , float y);
}
