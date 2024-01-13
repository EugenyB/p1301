package logic;

public class Geometry {

    private static final double EPS = 1e-9; // 0.000000001

    private Geometry() {}

    public static double distance(Point p1, Point p2) {
        return Math.hypot(p1.x()- p2.x(), p1.y()-p2.y());
    }

    public static boolean inRect(Point p1, Point p2, Point p) {
        double minX = Math.min(p1.x(), p2.x());
        double minY = Math.min(p1.y(), p2.y());
        double maxX = Math.max(p1.x(), p2.x());
        double maxY = Math.max(p1.y(), p2.y());
        return p.x() > minX - EPS && p.x() < maxX + EPS && p.y() > minY - EPS && p.y() < maxY + EPS;
    }

    public static double angle(Point p) {
        return Math.atan2(p.y(), p.x());
    }

    public static Point polarToDecart(double r, double alpha) {
        return new Point(r*Math.cos(alpha), r*Math.sin(alpha));
    }

    public static Point center(Point p1, Point p2) {
        return new Point((p1.x() + p2.x())/2, (p1.y() + p2.y())/2);
    }

    public static Point mToN(Point p1, Point p2, double m, double n) {
        return new Point((p1.x()*n+p2.x()*m)/(m+n),(p1.y()*n+p2.y()*m)/(m+n));
    }

    public static Point turn(Point p, double angle) {
        double x = p.x()*Math.cos(angle) - p.y()*Math.sin(angle);
        double y = p.x()*Math.sin(angle) + p.y()*Math.cos(angle);
        return new Point(x, y);
    }

    public static Line lineByTwoPoints(Point p1, Point p2) {
        double a = p2.y() - p1.y();
        double b = p1.x() - p2.x();
        double c = a * p1.x() + b * p1.y();
        return new Line(a, b, c);
    }

    public static int pointInLine(Line line, Point point) {
        double r = line.a() * point.x() + line.b() * point.y() - line.c();
        if (r < -EPS) return -1;
        if (r > EPS) return 1;
        return 0;
    }

    public static Point crossPoint(Line line1, Line line2) {
        double a1 = line1.a();
        double b1 = line1.b();
        double c1 = line1.c();
        double a2 = line2.a();
        double b2 = line2.b();
        double c2 = line2.c();

        double d = a1 * b2 - b1 * a2;
        double dx = c1 * b2 - b1 * c2;
        double dy = a1 * c2 - c1 * a2;

        return new Point(dx/d, dy/d);
    }

    public static boolean pointInSegment(Point p, Point p1, Point p2) {
        Line line = lineByTwoPoints(p1, p2);
        return Geometry.pointInLine(line, p) == 0 && Geometry.inRect(p1, p2, p);
    }
}
