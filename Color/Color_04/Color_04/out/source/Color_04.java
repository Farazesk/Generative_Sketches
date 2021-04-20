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

/*Programmer: Faraz Eskandari
  Variation for generative Design Book, Color 01.
  4/02/2021
*/


//Variables for max degree and radius of shape
float max = 45;
int r = 900;

//Array of objects
Polygon[] poly = new Polygon[8];

public void setup() {
    

    //Initiate of each object in array
    for (int i = 0; i < poly.length; ++i) {
        poly[i] = new Polygon(i * 45);
    }
}

public void draw() {
    //Move origin to center
    translate(width/2, height/2);
    //set background to black
    background(0);

    //For loop to execute each method
    for (int i = 0; i < poly.length; ++i) {
        poly[i].rotary();
        poly[i].reColor(mouseY, height);
        poly[i].display(max, r, mouseX, width, i);
    }
}
//Polygon class
class Polygon {
    //Variable for rotation of each polygon
    float rotation;
    //Variable for Hue
    float h;

    //Constructor of Polygon class
    Polygon(float _rotation) {
        //Rotation of each polygon
        rotation = radians(_rotation);
    }

    //Rotation method
    public void rotary() {
        rotate(rotation);
    }

    //Change heu base on mouseY location
    public void reColor(int _mouseY, int _height) {
        //Set color mode to HSB
        colorMode(HSB, 320, 100, 45);
        //Map mouseY to 0 and 80
        h = map(_mouseY, 0, _height, 0, 80);
    }

    //Display shape base on mouseX
    public void display(float _max, int _r, int _mouseX, int _width, int _index) {
        //Max degree of each polygon
        float max = _max;
        //Map mouseX to 0 and r
        float radius = map(_mouseX, 0, _width, 0, _r);
        
        //If max is more than 5
        if (max > 5) {
            //Using for loop for each polygon
            for (float r = radius; r > 100; r -= 50) {
                //Begin costume shape
                beginShape();
                
                //Uding for loop to draw curve line
                for (int theta = 0; theta <= max; theta += 1) {
                    //Fill base on itteration and mouseY
                    fill(_index * h, 100, theta);
                    //Stroke base of index of itteration
                    stroke(_index * h, 0, theta);
                    //Using cos and sin to draw curve line
                    float x = cos(radians(theta)) * r;
                    float y = sin(radians(theta)) * r;
                    //Vertex base of sin and cos
                    vertex(x, y);
                }
                //Vertex to center of shape
                vertex(0, 0);
                //Close the shape
                endShape(CLOSE);
                //Decrease max by 2.25 in each loop 
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
