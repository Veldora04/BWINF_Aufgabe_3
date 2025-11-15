package com.BWINF;

public class Geometry {

    // Projektion eines Punkts P auf eine Strecke A->B
    // gibt den KÜRZESTEN Abstand zurück
    public static double pointToSegment(Coordinate P, Coordinate A, Coordinate B) {

        Coordinate AP = Coordinate.sub(P, A);
        Coordinate AB = Coordinate.sub(B, A);

        double ab2 = Coordinate.dot(AB, AB);
        if (ab2 == 0) return Coordinate.distance(P, A); // A==B degeneriert

        double t = Coordinate.dot(AP, AB) / ab2;

        // t clamped auf [0,1]
        if (t < 0) t = 0;
        if (t > 1) t = 1;

        Coordinate foot = new Coordinate(
                A.getX() + AB.getX() * t,
                A.getY() + AB.getY() * t
        );

        return Coordinate.distance(P, foot);
    }


    // Abstand zweier Strecken A->B und C->D
    public static double segmentToSegment(Segment s1, Segment s2) {

        double d1 = pointToSegment(s1.a, s2.a, s2.b);
        double d2 = pointToSegment(s1.b, s2.a, s2.b);
        double d3 = pointToSegment(s2.a, s1.a, s1.b);
        double d4 = pointToSegment(s2.b, s1.a, s1.b);

        return Math.min(Math.min(d1, d2), Math.min(d3, d4));
    }


    // Abstand eines Segments zu einem Polygon (Liste von Koordinaten)
    public static double segmentToPolygon(Segment seg, java.util.List<Coordinate> poly) {
        double best = Double.POSITIVE_INFINITY;

        for (int i = 0; i < poly.size(); i++) {
            Coordinate A = poly.get(i);
            Coordinate B = poly.get((i + 1) % poly.size()); // Ring schließen
            Segment edge = new Segment(A, B);

            double d = segmentToSegment(seg, edge);
            best = Math.min(best, d);
        }
        return best;
    }
}

