/*Programmer: Faraz Eskandari
  Variation for generative Design Book, Color 01.
  3/29/2021
*/


//Total number of Diamonds
int total = 10;

//Array of Diamonds object
Diamond[] diamonds = new Diamond[total];

void setup() {
    size(2000, 2000);
    //Maximum size of each diamond
    int max = width / total;

    //Using for loop to initilize each object in array
    for (int i = 0; i < total; ++i) {
        diamonds[i] = new Diamond(0, 0, (total-i)*max/2, i);
    }
}

void draw() {
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

