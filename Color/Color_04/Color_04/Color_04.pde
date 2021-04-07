/*Programmer: Faraz Eskandari
  Variation for generative Design Book, Color 01.
  4/02/2021
*/


//Variables for max degree and radius of shape
float max = 45;
int r = 900;

//Array of objects
Polygon[] poly = new Polygon[8];

void setup() {
    size(2000, 2000);

    //Initiate of each object in array
    for (int i = 0; i < poly.length; ++i) {
        poly[i] = new Polygon(i * 45);
    }
}

void draw() {
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
