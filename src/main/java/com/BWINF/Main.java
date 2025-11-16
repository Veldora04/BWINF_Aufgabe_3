package com.BWINF;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Vector>[] data = Reader.read("src/main/resources/hund01.txt");

        double shortestDistanceToLake = Double.MAX_VALUE;
        String s = " ";

        /// Triangle with two edges from lake
        for (int i = 0; i < data[0].size(); i++) {
            Vector path = data[0].get(i);
            for (int j = 1; j < data.length; j++) {
                for (int k = 0; k < data[j].size(); k++) {
                    Vector lake1 = data[j].get(k);
                    Vector lake2 = data[j].get((k+1)%data[j].size());

                    Triangle triangle = new Triangle(lake1,lake2,path);

                    if (triangle.one_two_acute()) {
                        double temp = triangle.findHeight();
                        if (temp < shortestDistanceToLake) {
                            shortestDistanceToLake = temp;
                            s = lake1.toString() + "," + lake2.toString() + "," + path.toString();
                        }
                    } else {
                        double temp = triangle.shortestSideLengthWithThree();
                        if (temp < shortestDistanceToLake) {
                            shortestDistanceToLake = temp;
                            s = lake1.toString() + "," + lake2.toString() + "," + path.toString();
                        }
                    }
                }
            }
        }
        System.out.println();
        /// Triangle with two edges from path
        for (int j = 1; j < data.length; j++) {
            for (int k = 0; k < data[j].size(); k++) {
                Vector lake = data[j].get(k);
                for (int i = 0; i < data[0].size(); i = i + 2) {
                    Vector path1 = data[0].get(i);
                    Vector path2 = data[0].get(i+1);

                    Triangle triangle = new Triangle(path1,path2,lake);

                    if (triangle.one_two_acute()) {
                        double temp = triangle.findHeight();
                        if (temp < shortestDistanceToLake) {
                            shortestDistanceToLake = temp;
                            s = path1.toString() + "," + path2.toString() + "," + lake.toString();
                        }
                    } else {
                        double temp = triangle.shortestSideLengthWithThree();
                        if (temp < shortestDistanceToLake) {
                            shortestDistanceToLake = temp;
                            s = path1.toString() + "," + path2.toString() + "," + lake.toString();
                        }
                    }
                }
            }
        }

        System.out.println("From triangle: "+s);
        System.out.println("Shortest distance: "+shortestDistanceToLake);
    }
}

