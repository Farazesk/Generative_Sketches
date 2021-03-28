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

void setup() {
    size(2000, 2000);

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

void draw() {
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

