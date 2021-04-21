class Lines {
  //Cordinate of each tile
  int x, y;
  //Size of each tile
  int radius;
  //distance between each line in tiles
  int distance;
  //Variable to stare state random numbers
  float r;

  Lines(int _x, int _y, int _radius, int _distance) {
    x =_x;
    y = _y;
    radius = _radius;
    distance = _distance;
  }

  //Display function
  void display(float _r) { 
    stroke(#c7383a);
    noFill();
    rect(x, y, radius, radius);
    r = _r;
    //Draw each tile base on state argument   
    if (r <= 1 && r >= 0) {
      for (int i = x; i <= x + radius; i += distance) {
        line(x, y, i, y + radius);

        if (i == x + radius) {
          for (int j = y; j < y + radius; j += distance) {
            line(x, y, x + radius, j);
          }
        }
      }
    } else if (r <= 2 && r > 1) {
      for (int i = x + radius; i >= x; i -= distance) {
        line(x + radius, y, i, y + radius);

        if (i == x) {
          for (int j = y; j <= y + radius; j += distance) {
            line(x + radius, y, x, j);
          }
        }
      }
    } else if (r <= 3 && r > 2) {
      for (int i = x + radius; i >= x; i -= distance) {
        line(x + radius, y + radius, i, y);

        if (i == x) {
          for (int j = y; j <= y + radius; j += distance) {
            line(x + radius, y + radius, x, j);
          }
        }
      }
    } else if (r <= 4 && r > 3) {
      for (int i = x; i >= x + radius; i += distance) {
        line(x, y + radius, i, y);

        if (i == x + radius) {
          for (int j = y + radius; j >= y; j -= distance) {
            line(x, Y + radius, x + radius, j);
          }
        }
      }
    }
  }
}
