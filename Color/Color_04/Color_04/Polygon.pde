//Polygon class
class Polygon {
    //Variable for rotation of each polygon
    float rotation;
    //Variable for Hue
    float h;

    //Constructor of Polygon class
    Polygon(float _rotation) {
        //Rotation of each polygon
        rotation = radians(_rotation);
    }

    //Rotation method
    void rotary() {
        rotate(rotation);
    }

    //Change heu base on mouseY location
    void reColor(int _mouseY, int _height) {
        //Set color mode to HSB
        colorMode(HSB, 320, 100, 45);
        //Map mouseY to 0 and 80
        h = map(_mouseY, 0, _height, 0, 80);
    }

    //Display shape base on mouseX
    void display(float _max, int _r, int _mouseX, int _width, int _index) {
        //Max degree of each polygon
        float max = _max;
        //Map mouseX to 0 and r
        float radius = map(_mouseX, 0, _width, 0, _r);
        
        //If max is more than 5
        if (max > 5) {
            //Using for loop for each polygon
            for (float r = radius; r > 100; r -= 50) {
                //Begin costume shape
                beginShape();
                
                //Uding for loop to draw curve line
                for (int theta = 0; theta <= max; theta += 1) {
                    //Fill base on itteration and mouseY
                    fill(_index * h, 100, theta);
                    //Stroke base of index of itteration
                    stroke(_index * h, 0, theta);
                    //Using cos and sin to draw curve line
                    float x = cos(radians(theta)) * r;
                    float y = sin(radians(theta)) * r;
                    //Vertex base of sin and cos
                    vertex(x, y);
                }
                //Vertex to center of shape
                vertex(0, 0);
                //Close the shape
                endShape(CLOSE);
                //Decrease max by 2.25 in each loop 
                max -= 2.25;
            }
        }
    }
}