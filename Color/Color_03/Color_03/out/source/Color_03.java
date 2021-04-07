import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Color_03 extends PApplet {

/*Programmer: Faraz Eskandari
  Variation for generative Design Book, Color 01.
  3/29/2021
*/

//Total number of rectangles
int total = 200;
//Variable for each rectangle
int w;

//Array of objects
Rectangle[] recangles = new Rectangle[total];

public void setup() {
    
    //Calculate width of rectangles base width size
    w = width/total;

    //Initiation of each objects
    for (int i = 0; i < total; ++i) {
        recangles[i] = new Rectangle(i*w + (w/2), height, random(200, height));
    }
}

public void draw() {
    //Map mouseY to variable for background's HUE
    float h = map(mouseY, 0, height, 360, 0);
    colorMode(HSB, 360, 100, 100);
    background(h, 100, 100);

    //For loop to execute each method of objects
    for (int i = 0; i < total; ++i) {
        recangles[i].resize(mouseX);
        recangles[i].recolor(mouseY, i, total);
        recangles[i].display(w);
    }
}
class Rectangle{
    //Position of each rectangles
    int x, y;
    //Maximum size of each rectangle
    float heightMax;
    //Hue of fill color
    float colorHEU;
    //Height size of each rectangle
    float rectHeight;

    Rectangle(int _x, int _height, float _heightMax) {
        x = _x;
        y = _height/2;
        heightMax = _heightMax;
        colorHEU = 0;
    }

    //Method for changing height of rectangles base on mouseX
    public void resize(int _mouseX) {
        int mx = _mouseX;
        rectHeight = map(mx, x, width, 0, heightMax);
        rectHeight = constrain(rectHeight, 0, heightMax);
    }

    //Method for changing color base on mouseY
    public void recolor(int _mouseY, int _index, int _total) {
        int my = _mouseY;
        int index = _index;
        int degree = 360 / total;
        colorHEU = map(my, 0, height, index*degree, 360 + index*degree);
    }   

    //Method for display rectangles
    public void display(int _w) {
        colorMode(HSB, 360, 100, 100);
        fill(colorHEU, 100, 100);
        stroke(0, 0, 0);
        
        rectMode(CENTER);
        int w = _w;
        rect(x, y, w, rectHeight);
    }
}
  public void settings() {  size(2000, 2000); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Color_03" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
