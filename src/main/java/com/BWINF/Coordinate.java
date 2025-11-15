package com.BWINF;

public class Coordinate {

    public double x;
    public double y;

    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public boolean middle(Coordinate one, Coordinate two) {
        return (one.x > x && two.x < x) || (one.x < x && two.x > x);
    }

    public Coordinate closerXValue(Coordinate one, Coordinate two) {
        double deltaOne = Math.abs(x-one.x);
        double deltaTwo = Math.abs(x-two.x);

        return (deltaOne > deltaTwo ? two : one);
    }

    public static Coordinate sub(Coordinate a, Coordinate b) {
        return new Coordinate(a.x - b.x, a.y - b.y);
    }

    // <a,b>
    public static double dot(Coordinate a, Coordinate b) {
        return a.x * b.x + a.y * b.y;
    }

    // Norm
    public static double distance(Coordinate a, Coordinate b) {
        double dx = a.x - b.x;
        double dy = a.y - b.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public String toString() {
        return "(" + x + "|" + y + ")";
    }
}
