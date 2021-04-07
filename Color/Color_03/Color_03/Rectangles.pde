class Rectangle{
    //Position of each rectangles
    int x, y;
    //Maximum size of each rectangle
    float heightMax;
    //Hue of fill color
    float colorHEU;
    //Height size of each rectangle
    float rectHeight;

    Rectangle(int _x, int _height, float _heightMax) {
        x = _x;
        y = _height/2;
        heightMax = _heightMax;
        colorHEU = 0;
    }

    //Method for changing height of rectangles base on mouseX
    void resize(int _mouseX) {
        int mx = _mouseX;
        rectHeight = map(mx, x, width, 0, heightMax);
        rectHeight = constrain(rectHeight, 0, heightMax);
    }

    //Method for changing color base on mouseY
    void recolor(int _mouseY, int _index, int _total) {
        int my = _mouseY;
        int index = _index;
        int degree = 360 / total;
        colorHEU = map(my, 0, height, index*degree, 360 + index*degree);
    }   

    //Method for display rectangles
    void display(int _w) {
        colorMode(HSB, 360, 100, 100);
        fill(colorHEU, 100, 100);
        stroke(0, 0, 0);
        
        rectMode(CENTER);
        int w = _w;
        rect(x, y, w, rectHeight);
    }
}