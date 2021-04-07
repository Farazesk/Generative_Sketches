/*Programmer: Faraz Eskandari
  Variation for generative Design Book, Color 01.
  4/02/2021
*/

//Total number of rectangles
int total = 200;
//Variable for each rectangle
int w;

//Array of objects
Rectangle[] recangles = new Rectangle[total];

void setup() {
    size(2000, 2000);
    //Calculate width of rectangles base width size
    w = width/total;

    //Initiation of each objects
    for (int i = 0; i < total; ++i) {
        recangles[i] = new Rectangle(i*w + (w/2), height, random(200, height));
    }
}

void draw() {
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
