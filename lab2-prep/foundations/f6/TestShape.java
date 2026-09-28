// F6 - ABSTRACT, FINAL, INTERFACES. Shape, Resizable, Ring are given. Write class Circle in Circle.java.
abstract class Shape {
    final String kind;
    static int shapes = 0;

    Shape(String kind) {
        this.kind = kind;
        shapes++;
    }

    abstract double area();

    String info() {
        return kind + ":" + Math.round(area());
    }

    final String tag() {
        return "#" + kind;
    }
}

interface Resizable {
    int MAX = 10;

    void resize(int f);

    default boolean big() {
        return false;
    }
}

class Ring extends Circle {
    int hole;

    Ring(int r, int hole) {
        super(r);
        this.hole = hole;
    }

    double area() {
        return super.area() - 3 * hole * hole;
    }
}

public class TestShape {

    static int testCounter = 1;

    static void tester(boolean b) {
        String status = "Failed";
        if (b)
            status = "Passed";
        System.out.printf("Test #%02d %s.%n", testCounter++, status);
    }

    public static void main(String[] args) {
        Circle c = new Circle(2);
        tester(c.r == 2 && c.kind.equals("circle") && Shape.shapes == 1);
        tester(c.area() == 12.0 && c.info().equals("circle:12"));
        Shape s = c;
        tester(s.tag().equals("#circle") && s.area() == 12.0);
        Resizable z = c;
        z.resize(3);
        tester(c.r == 6 && z.big() && Resizable.MAX == 10);
        z.resize(5);
        tester(c.r == 10);
        Shape g = new Ring(3, 1);
        tester(g.area() == 24.0 && g.info().equals("circle:24") && Shape.shapes == 2);
        tester(g instanceof Resizable && !((Resizable) g).big());
        Shape[] arr = { c, g, new Circle(1) };
        tester(Circle.totalArea(arr) == 327.0);
        tester(c.equals(new Circle(10)) && !c.equals(g));
        tester(Shape.shapes == 4);
    }
}
