//Rectangle class
class Rectangle {
    //Positon of each rectangle
    int x, y;
    //maximum size of each rectangle
    float h;
    //Variable for HEU
    float c;
    //Variable for changing size of rectangles
    float diameter;

    //Constructor of Rectangles, pass in x, y and maximum size of each rectangle
    Rectangle(int _x, int _y, int _h) {
        x = _x;
        y = _y;
        h = _h;
    }

    //Passing width of window and mouseX for resizing rectangles base on mouse location
    void resize(int _width, int _mouseX) {
        int mx = _mouseX;
        diameter = map(mx, 0, _width, 0, h);
    }

    //Passing height and mouseY for changing hue base on mouse location
    void reColor(int _mouseY, int _height) {
        c = map(_mouseY, 0, _height, 0, 360);
    }


    //Display rectangles
    void display() {
        colorMode(HSB, 360, 100, 100);
        noStroke();
        fill(c, 100, 100);
        rectMode(CENTER);
        rect(x, y, diameter, diameter);
    }
    
}