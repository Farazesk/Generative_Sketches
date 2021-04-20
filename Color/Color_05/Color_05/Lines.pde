class Lines {
    float x1, y1;
    float x2, y2;
    float theta1, theta2;
    int r;
    int lw;
    float low, high;
    float h;
    float a;

    Lines(float _theta1, float _theta2, int _r, int _lw, float _low, float _high, float _a) {
        theta1 = _theta1;
        theta2 = _theta2;
        r = _r;
        lw = _lw;
        low = _low;
        high = _high;
        h = random(255);
        a = _a;
    }

    void position() {
        x1 = cos(theta1) * r;
        y1 = sin(theta1) * r;

        x2 = cos(theta2) * r;
        y2 = sin(theta2) * r;
    }

    void rotary(int _mouseX) {
        float mx = map(_mouseX, 0, width, low, high);
        rotate(mx);
    }

    void display() {
        noFill();
        stroke(h, a);
        strokeWeight(1);
        // ellipse(0, 0, r*2, r*2);
        strokeWeight(lw);
        line(x1, y1, x2, y2);
        ellipse(x1, y1, 100, 100);
        ellipse(x2, y2, 100, 100);

    }
    

}