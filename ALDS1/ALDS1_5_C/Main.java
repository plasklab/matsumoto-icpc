import java.io.*;
import java.util.Scanner;

class Point {
  double x;
  double y;
}

public class Main {

  void koch(int d, Point p1, Point p2) {
    if(d == 0)
      return;
    Point s = new Point();
    s.x = (2 * p1.x + p2.x) / 3;
    s.y = (2 * p1.y + p2.y) / 3;
    Point t = new Point();
    t.x = (p1.x + 2 * p2.x) / 3;
    t.y = (p1.y + 2 * p2.y) / 3;
    Point u = new Point();
    u.x = (t.x - s.x) * Math.cos(Math.toRadians(60)) - (t.y - s.y) * Math.sin(Math.toRadians(60)) + s.x;
    u.y = (t.x - s.x) * Math.sin(Math.toRadians(60)) + (t.y - s.y) * Math.cos(Math.toRadians(60)) + s.y;

    koch(d - 1, p1, s);
    System.out.printf("%f %f\n", s.x, s.y);
    koch(d - 1, s, u);
    System.out.printf("%f %f\n", u.x, u.y);
    koch(d - 1, u, t);
    System.out.printf("%f %f\n", t.x, t.y);
    koch(d - 1, t, p2);
  }

  void run() {
      Scanner scan = new Scanner(System.in);
      int n = scan.nextInt();
      Point p1 = new Point();
      Point p2 = new Point();
      p2.x = 100;

      System.out.printf("%f %f\n", p1.x, p1.y);
      koch(n, p1, p2);
      System.out.printf("%f %f\n", p2.x, p2.y);
  }

  public static void main(String[] args) {
    new Main().run();
  }
}
