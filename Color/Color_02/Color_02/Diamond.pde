//Diamond class
class Diamond {
    //Location of Diamond
    int x, y;
    //Maximum size of Diamond
    float h;
    //size of Diamond
    float diameter;
    //Hue of color
    float colorHue;
    //Index number of each Diamond
    int n;

    //Diamond class constructor, pass in x, y, maximum size of Diamonds and index number
    Diamond(int _x, int _y, float _h, int _i) {
        x = _x;
        y = _y;
        h = _h;
        n = _i;
    }

    //Function for changing size of each Diamond base on mouseX location
    void resize(int _mouseX) {
        int mx = _mouseX;
        diameter = map(mx, 0, width, 0, h);
    }

    //Function for changing Hue of each Diamond base on mouseY location
    void reColor(int _mouseY) {
        colorHue = map(mouseY, 0, height, 0, 360);
    }

    void display(int _width, int _height) {
        pushMatrix();    
        translate(_width/2, _height/2);

        colorMode(HSB, 360, 100, 100);

        //Choose fill color base on index number
        if (n%2==0) {
            fill(colorHue, 100, 100);
        } else {
            fill(360 - colorHue, 100, 100);
        }
        
        //Diamond shape
        beginShape();
        vertex(diameter, 0);
        vertex(0, diameter);
        vertex(-diameter, 0);
        vertex(0, -diameter);
        endShape(CLOSE);

        popMatrix();
    }
}