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

public class Color_01 extends PApplet {

/*Programmer: Faraz Eskandari
  Variation for generative Design Book, Color 01.
  3/28/2021
*/
  

//Total number of recangles in each row
int total = 16;

//Size of object array
int colls = total;
int rows = total;

//Declaretion of 2d array of object
Rectangle[] [] rectangles = new Rectangle[colls][rows];

public void setup() {
    

    //Maximum size of each rectangle
    int h = width / total;

    //construct each object with nested for loop
    for (int i = 0; i < colls; ++i) {
        for (int j = 0; j < rows; ++j) {
            //Passing in location of each rectangle and maximum size of each 
            rectangles[i][j] = new Rectangle(i*h + h/2, j*h + h/2, h);
        }
    }
}

public void draw() {
    //Variable for changing Hue of background base on mouseY location
    float h = map(mouseY, 0, height, 360, 0);
    //Changing color mode to HSB
    colorMode(HSB, 360, 100, 100);
    //Use h as input to change hue
    background(h, 100, 100);

    //Using two nested for loop to display each rectangle
    for (int i = 0; i < colls; ++i) {
        for (int j = 0; j < rows; ++j) {
            rectangles[i][j].display();
            rectangles[i][j].reColor(mouseY, height);
            rectangles[i][j].resize(width, mouseX);
        }
    }
}

//Rectangle class
class Rectangle {
    //Positon of each rectangle
    int x, y;
    //maximum size of each rectangle
    float h;
    //Variable for HEU
    float c;
    //Variable for changing size of rectangles
    float diameter;

    //Constructor of Rectangles, pass in x, y and maximum size of each rectangle
    Rectangle(int _x, int _y, int _h) {
        x = _x;
        y = _y;
        h = _h;
    }

    //Passing width of window and mouseX for resizing rectangles base on mouse location
    public void resize(int _width, int _mouseX) {
        int mx = _mouseX;
        diameter = map(mx, 0, _width, 0, h);
    }

    //Passing height and mouseY for changing hue base on mouse location
    public void reColor(int _mouseY, int _height) {
        c = map(_mouseY, 0, _height, 0, 360);
    }


    //Display rectangles
    public void display() {
        colorMode(HSB, 360, 100, 100);
        noStroke();
        fill(c, 100, 100);
        rectMode(CENTER);
        rect(x, y, diameter, diameter);
    }
    
}
  public void settings() {  size(2000, 2000); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Color_01" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
