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

public class Color_02 extends PApplet {

/*Programmer: Faraz Eskandari
  Variation for generative Design Book, Color 01.
  3/29/2021
*/


//Total number of Diamonds
int total = 10;

//Array of Diamonds object
Diamond[] diamonds = new Diamond[total];

public void setup() {
    
    //Maximum size of each diamond
    int max = width / total;

    //Using for loop to initilize each object in array
    for (int i = 0; i < total; ++i) {
        diamonds[i] = new Diamond(0, 0, (total-i)*max/2, i);
    }
}

public void draw() {
    //Change color mode to HSB
    colorMode(HSB, 360, 100, 100);
    //Using mouseY location for hue of background
    float h = map(mouseY, 0, height, 360, 0);
    background(h, 100, 100);

    //Using for loop to run each mothod of diamonds object
    for (int i = 0; i < total; ++i) {
        diamonds[i].resize(mouseX);
        diamonds[i].reColor(mouseY);
        diamonds[i].display(width, height);
    }
}

//Diamond class
class Diamond {
    //Location of Diamond
    int x, y;
    //Maximum size of Diamond
    float h;
    //size of Diamond
    float diameter;
    //Hue of color
    float colorHue;
    //Index number of each Diamond
    int n;

    //Diamond class constructor, pass in x, y, maximum size of Diamonds and index number
    Diamond(int _x, int _y, float _h, int _i) {
        x = _x;
        y = _y;
        h = _h;
        n = _i;
    }

    //Function for changing size of each Diamond base on mouseX location
    public void resize(int _mouseX) {
        int mx = _mouseX;
        diameter = map(mx, 0, width, 0, h);
    }

    //Function for changing Hue of each Diamond base on mouseY location
    public void reColor(int _mouseY) {
        colorHue = map(mouseY, 0, height, 0, 360);
    }

    public void display(int _width, int _height) {
        pushMatrix();    
        translate(_width/2, _height/2);

        colorMode(HSB, 360, 100, 100);

        //Choose fill color base on index number
        if (n%2==0) {
            fill(colorHue, 100, 100);
        } else {
            fill(360 - colorHue, 100, 100);
        }
        
        //Diamond shape
        beginShape();
        vertex(diameter, 0);
        vertex(0, diameter);
        vertex(-diameter, 0);
        vertex(0, -diameter);
        endShape(CLOSE);

        popMatrix();
    }
}
  public void settings() {  size(2000, 2000); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Color_02" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
