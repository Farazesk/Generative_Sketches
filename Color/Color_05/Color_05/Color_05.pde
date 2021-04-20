/*Programmer: Faraz Eskandari
  Variation for generative Design Book, Color 01.
  4/14/2021
*/


Lines[] linesBig = new Lines[65];
Lines[] linesSmall = new Lines[500];

void setup() {
    size(2000, 2000, P2D);
    background(0);
    smooth();
    blendMode(ADD);

    for (int i = 0; i < linesBig.length; ++i) {
        linesBig[i] = new Lines(random(0, PI), random(PI, TWO_PI), 900, 3, 0, TWO_PI, 150);
    }

    for (int i = 0; i < linesSmall.length; ++i) {
        linesSmall[i] = new Lines(random(0, PI), random(PI, TWO_PI), 500, 6, TWO_PI, 0, 40);
    }
}

void draw() {
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
