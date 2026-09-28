class Point {
  private int x, y;
  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
  public int getX() {
    return x;
  }
  public void setX(int x) {
    this.x = x;
  }
  public int getY() {
    return y;
  }
  public void setY(int y) {
    this.y = y;
  }
}
interface Shape {
  double area();
  Point getPoint();
}
class Rectangle implements Shape{
  private Point p;
  private double height, width;
  Rectangle(Point p, double height, double width) {
    this.p = p;
    this.height = height;
    this.width = width;
  }
  public double getHeight() {
    return height;
  }
  public void setHeight(double height) {
    this.height = height;
  }
  public double getWidth() {
    return width;
  }
  public void setWidth(double width) {
    this.width = width;
  }
  public double area() {
    return height * width;
  }
  public Point getPoint() {
    return p;
  }
}
class Circle implements Shape {
  private Point p;
  private double r;
  Circle(Point p, double r) {
    this.p = p;
    this.r = r;
  }
  public double getRadius() {
    return r;
  }
  public void setRadius(double r) {
    this.r = r;
  }
  public double area() {
    return 3.1416 * r * r;
  }
  public Point getPoint() {
    return p;
  }
}

public class J14_5C {
  public static void main(String[] args) {
    Point p = new Point(11, 22);
    System.out.println("Point: " + p.getX() + ", " + p.getY());
    Rectangle r = new Rectangle(p, 30.0, 50.0);
    System.out.println("R: " + r.getHeight() + ", " + r.getWidth());
    System.out.println("R-Area: " + r.area());
    r.setWidth(9.0);
    r.setHeight(7.0);
    Shape s = r;
    System.out.println("S-Area: " + s.area());
    System.out.println("S-Point: " + s.getPoint().getX() + ", " + s.getPoint().getY());
    p.setX(5);
    p.setY(7);
    Circle c = new Circle(p, 7.0);
    System.out.println("C: " + c.getRadius() + ", C-Area: " + c.area());
    c.setRadius(5.0);
    s = c;
    System.out.println("S-Area: " + s.area());
  }
}
