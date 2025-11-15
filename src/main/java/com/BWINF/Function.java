package com.BWINF;

public class Function {

    private double m;
    private double t;

    public Function(Coordinate one, Coordinate two) {
        findFunction(one,two);
    }

    public double getM() {
        return m;
    }

    public void setM(double m) {
        this.m = m;
    }

    public double getT() {
        return t;
    }

    public void setT(double t) {
        this.t = t;
    }

    private void findFunction(Coordinate one, Coordinate two) {
        try {
            double slope = (one.getY() - two.getY()) / (one.getX() - two.getX());
            setT(one.getY()-slope*one.getX());
            setM(slope);
        } catch (Exception e) {
            System.out.println("Divde By zero!!!");   ///ToDo
        }
    }

    public Coordinate intersection(Function other) {
        double x = (other.getT() - t)/(m - other.getM());
        double y = m*x + t;
        return new Coordinate(x,y);
    }

}
