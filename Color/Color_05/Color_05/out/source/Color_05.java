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

public class Color_05 extends PApplet {

/*Programmer: Faraz Eskandari
  Variation for generative Design Book, Color 01.
  4/14/2021
*/


Lines[] linesBig = new Lines[65];
Lines[] linesSmall = new Lines[500];

public void setup() {
    
    background(0);
    
    blendMode(ADD);

    for (int i = 0; i < linesBig.length; ++i) {
        linesBig[i] = new Lines(random(0, PI), random(PI, TWO_PI), 900, 3, 0, TWO_PI, 150);
    }

    for (int i = 0; i < linesSmall.length; ++i) {
        linesSmall[i] = new Lines(random(0, PI), random(PI, TWO_PI), 500, 6, TWO_PI, 0, 40);
    }
}

public void draw() {
    background(0);
    translate(width/2, height/2);

    for (int i = 0; i < linesBig.length; ++i) {
        linesBig[i].position();
        linesBig[i].display();
    }

    for (int i = 0; i < linesSmall.length; ++i) {
        linesSmall[i].position();
        linesSmall[i].display();
    }
    
    println(frameRate);
     saveFrame("lines-03.png");
    noLoop();
}
class Lines {
    float x1, y1;
    float x2, y2;
    float theta1, theta2;
    int r;
    int lw;
    float low, high;
    float h;
    float a;

    Lines(float _theta1, float _theta2, int _r, int _lw, float _low, float _high, float _a) {
        theta1 = _theta1;
        theta2 = _theta2;
        r = _r;
        lw = _lw;
        low = _low;
        high = _high;
        h = random(255);
        a = _a;
    }

    public void position() {
        x1 = cos(theta1) * r;
        y1 = sin(theta1) * r;

        x2 = cos(theta2) * r;
        y2 = sin(theta2) * r;
    }

    public void rotary(int _mouseX) {
        float mx = map(_mouseX, 0, width, low, high);
        rotate(mx);
    }

    public void display() {
        noFill();
        stroke(h, a);
        strokeWeight(1);
        // ellipse(0, 0, r*2, r*2);
        strokeWeight(lw);
        line(x1, y1, x2, y2);
        ellipse(x1, y1, 100, 100);
        ellipse(x2, y2, 100, 100);

    }
    

}
  public void settings() {  size(2000, 2000, P2D);  smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Color_05" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
