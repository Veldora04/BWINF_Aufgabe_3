package com.BWINF;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;


public class Reader {

    public static ArrayList<Coordinate>[] read(String s) throws IOException {

        Path path = Path.of("src/main/resources/"+s);
        String content = Files.readString(path);
        String[] parts = content.trim().split("\\s+");

        int index = 0;

        //Paths
        int k = Integer.parseInt(parts[index++]); // numbPath

        @SuppressWarnings("unchecked") // not necessary just irritating to look at
        ArrayList<Coordinate>[] res = new ArrayList[1];
        ArrayList<Coordinate> paths = new ArrayList<>();

        // every Path: x1 y1 x2 y2
        for (int i = 0; i < k; i++) {
            long x1 = Long.parseLong(parts[index++]);
            long y1 = Long.parseLong(parts[index++]);
            long x2 = Long.parseLong(parts[index++]);
            long y2 = Long.parseLong(parts[index++]);

            paths.add(new Coordinate(x1, y1));
            paths.add(new Coordinate(x2, y2));
        }

        res[0] = paths;

        // Lakes
        int numbLakes = Integer.parseInt(parts[index++]); //

        // array length adjust
        res = Arrays.copyOf(res, numbLakes + 1);

        for (int lake = 1; lake <= numbLakes; lake++) {

            int n = Integer.parseInt(parts[index++]); // number of corners
            ArrayList<Coordinate> lakeCoords = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                long x = Long.parseLong(parts[index++]);
                long y = Long.parseLong(parts[index++]);
                lakeCoords.add(new Coordinate(x, y));
            }

            res[lake] = lakeCoords;
        }

        return res;
    }

}
