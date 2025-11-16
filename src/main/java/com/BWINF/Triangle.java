package com.BWINF;

public class Triangle {

    private Vector one; // just the coordinates not the sides of the Triangle
    private Vector two; // one and two are always the base for the triangle and three the point
    private Vector three;

    public Triangle(Vector one, Vector two, Vector three) {
        this.one = one;
        this.two = two;
        this.three = three;
    }

    public Vector getOne() {
        return one;
    }

    public Vector getTwo() {
        return two;
    }

    public Vector getThree() {
        return three;
    }

    public double shortestSideLengthWithThree() {

        Vector secondSide = three.sub(two);
        Vector thirdSide = one.sub(three);

        double secondLength = secondSide.norm2();
        double thirdLength = thirdSide.norm2();

        double shortest = secondLength;

        if (shortest > thirdLength) shortest = thirdLength;

        return shortest;
    }

    public boolean one_two_acute() {

        Vector firstAngle1 = two.sub(one);
        Vector firstAngle2 = three.sub(one);

        if (firstAngle1.angle(firstAngle2) - 90.0 > 0.0) return false;

        Vector secondAngle1 = one.sub(two);
        Vector secondAngle2 = three.sub(two);

        if (secondAngle1.angle(secondAngle2) - 90.0 > 0.0) return false;

        // edge case for degenerate triangles

        if (findHeight() == 0) return false;

        return true;
    }

    public double findHeight() {

        Vector firstSide = two.sub(one);
        Vector secondSide = three.sub(two);
        Vector thirdSide = three.sub(one);

        double firstLength = firstSide.norm2();
        double secondLength = secondSide.norm2();
        double thirdLength = thirdSide.norm2();

        // Heron-Formula for triangle-area or with calc height with vector product directly to be decided

        // Heron
        double s = (firstLength+secondLength+thirdLength)/2;
        double area = Math.sqrt(s*(s-firstLength)*(s-secondLength)*(s-thirdLength));

        // Vector-Product
        //return (Math.abs(firstSide.getX()*thirdSide.getY() - firstSide.getY()*thirdSide.getX())/firstLength);

        return (2*area)/firstLength;  /// <==  A=1/2*base*height
    }
}
