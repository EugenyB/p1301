import logic.Geometry;
import logic.Line;
import logic.Point;

import java.math.MathContext;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
//        Point point1 = new Point(1, 1);
//        Point point2 = new Point(4, 5);  // 3 4 5
//        double r = Geometry.distance(point1, point2);
//        System.out.println("r = " + r);

//        Point a = new Point(0, -5);
//        double alpha = Geometry.angle(a);
//        System.out.println("alpha = " + alpha);

//        Point a = new Point(0,1);
//        Point b = new Point(10,11);
//        Point c = Geometry.mToN(a,b,3,7);
//        System.out.println(c);

//        Point p = new Point(10, 0);
//        Point point = Geometry.turn(p, 60 * Math.PI / 180);// PI -> 180
//        System.out.println(point);

        Line line1 = Geometry.lineByTwoPoints(new Point(0,0), new Point(10, 10));
        Line line2 = Geometry.lineByTwoPoints(new Point(0,10), new Point(10, 0));

        Point p = Geometry.crossPoint(line1, line2);
        System.out.println(p);
    }
}
