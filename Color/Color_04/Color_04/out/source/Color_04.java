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

public class Color_04 extends PApplet {

float max = 45;
int r = 900;

Polygon[] poly = new Polygon[8];

public void setup() {
    

    for (int i = 0; i < poly.length; ++i) {
        poly[i] = new Polygon(i * 45);
    }
}

public void draw() {
    translate(width/2, height/2);
    
    background(0);

    for (int i = 0; i < poly.length; ++i) {
        poly[i].rotary();
        poly[i].reColor(mouseY, height);
        poly[i].display(max, r, mouseX, width, i);
    }
}
class Polygon {
    float rotation;
    float h;

    Polygon(float _rotation) {
        rotation = radians(_rotation);
    }

    public void rotary() {
        rotate(rotation);
    }

    public void reColor(int _mouseY, int _height) {
        colorMode(HSB, 320, 100, 45);
        h = map(_mouseY, 0, _height, 0, 80);
    }

    public void display(float _max, int _r, int _mouseX, int _width, int _index) {
        float max = _max;
        float radius = map(_mouseX, 0, _width, 0, _r);

        stroke(255);
        // noFill();
        
        if (max > 5) {

            for (float r = radius; r > 100; r -= 50) {
                beginShape();
                
                for (int theta = 0; theta <= max; theta += 1) {
                    fill(_index * h, 100, theta);
                    stroke(_index * h, 0, theta);
                    float x = cos(radians(theta)) * r;
                    float y = sin(radians(theta)) * r;
                    vertex(x, y);
                }
            
                vertex(0, 0);
                endShape(CLOSE);
                max -= 2.25f;
            }
        }
    }
}
  public void settings() {  size(2000, 2000); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Color_04" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
