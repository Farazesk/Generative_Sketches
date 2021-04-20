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

void setup() {
    size(2000, 2000, P2D);

    //width and height of each tile
    tileW = width/cols;
    tileH = height/rows;

    smooth();

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

void draw() {
    background(#fafaff);
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

    