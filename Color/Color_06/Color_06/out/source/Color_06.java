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

public class Color_06 extends PApplet {

/*Programmer: Faraz Eskandari
  Variation for generative Design Book, Color 01.
  4/20/2021
*/

// import com.hamoid.*;

// VideoExport videoExport;

//Number of rectangle in each col
int cols = 10;
//Number of rectangle in each row
int rows = 10;

//Variables for tile width and height
int tileW, tileH;

//Timer Object
Timer timer;

//2d array of lines
Lines[][] lines = new Lines[cols][rows];

//2d array for random states
float[][] state = new float [cols][rows];

//Distance between lines
int distance = 10;

public void setup() {
    

    //width and height of each tile
    tileW = width/cols;
    tileH = height/rows;

    

    //Video export 
    // videoExport = new VideoExport(this);
    // videoExport.startMovie();

    //Initializing lines objects
    for (int i = 0; i < state.length; ++i) {
        for (int j = 0; j < state.length; ++j) {
            state[i][j] = random(4);
        }
    }
    
    //Iniatializing state objects
    for (int x = 0; x < lines.length; ++x) {
        for (int y = 0; y < lines.length; ++y) {
            lines[x][y] = new Lines(x, y, tileW, distance);
        }
    }

    //Initiaizing timer object
    timer = new Timer(2000);
    //Start the timer
    timer.start();
}

public void draw() {
    background(0xfffafaff);
    strokeWeight(2);
    
    //Reset timer and state objects
    if (timer.isFinished()) {
        for (int i = 0; i < state.length; ++i) {
            for (int j = 0; j < state.length; ++j) {
                state[i][j] = random(4);
        }
    }   
        //Start Timer
        timer.start();
    }

    for (int x = 0; x < lines.length; ++x) {
        for (int y = 0; y < lines.length; ++y) {
            pushMatrix();
            //Translate to each tile cordinate
            translate(x*tileW, y*tileW);
            //Draw lines base on state nubers
            lines[x][y].display(state[x][y]);
            popMatrix();
        }
    }

    //Save sketch as a movie file
    // videoExport.saveFrame();

}

//Press Q for stop the sketch
// void keyPressed() {
//   if (key == 'q') {
//     videoExport.endMovie();
//     exit();
//   }
// }

    
class Lines {
    //Cordinate of each tile
    int x, y;
    //Size of each tile
    int radius;
    //distance between each line in tiles
    int distance;
    //Variable to stare state random numbers
    float r;

    Lines(int _x, int _y, int _radius, int _distance) {
        x =_x;
        y = _y;
        radius = _radius;
        distance = _distance;
    }

    //Display function
    public void display(float _r) { 
        stroke(0xffc7383a);
        noFill();
        rect(x, y, radius, radius);
        r = _r;
        //Draw each tile base on state argument   
        if (r <= 1 && r >= 0) {
            for (int i = x; i <= x + radius; i += distance) {
                line(x, y, i, y + radius);

                if (i == x + radius) {
                    for (int j = y; j < y + radius; j += distance) {
                    line(x, y, x + radius, j);
                    }
                }
            }
        } else if (r <= 2 && r > 1) {
            for (int i = x + radius; i >= x; i -= distance) {
                line(x + radius, y, i, y + radius);

                if (i == x) {
                    for (int j = y; j <= y + radius; j += distance) {
                    line(x + radius, y, x, j);
                    }
                }
            }
        } else if (r <= 3 && r > 2) {
            for (int i = x + radius; i >= x; i -= distance) {
                line(x + radius, y + radius, i, y);

                if (i == x) {
                    for (int j = y; j <= y + radius; j += distance) {
                    line(x + radius, y + radius, x, j);
                    }
                }
            }
        } else if (r <= 4 && r > 3) {
            for (int i = x; i >= x + radius; i += distance) {
                line(x, y + radius, i, y);

                if (i == x + radius) {
                    for (int j = y + radius; j >= y; j -= distance) {
                    line(x, Y + radius, x + radius, j);
                    }
                }
            }
        } 
    }
}
class Timer {
    int savedTime;
    float totalTime;


    Timer (float _totalTime) {
        totalTime = _totalTime;
    }

    public void start() {
        savedTime = millis();
    }

    public boolean isFinished() {
        int passedTime = millis() - savedTime;
        if (passedTime > totalTime) {
            return true;
        } else {
            return false;
        }
    }
}
  public void settings() {  size(2000, 2000, OPENGL);  smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Color_06" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
