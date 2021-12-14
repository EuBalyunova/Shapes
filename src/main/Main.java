package main;
import java.nio.file.Paths;

import action.CubeMethods;
import entity.*;

public class Main {
    public static void main(String[] args) {
        ShapesFactory factory = new ShapesFactory();

        Shape point = factory.getShape(ShapeType.POINT);
        Shape cube = factory.getShape(ShapeType.CUBE);
        Shape cube1 = factory.getShape(ShapeType.CUBE);
        Shape cube2 = factory.getShape(ShapeType.CUBE);

        point.set(Paths.get("d://NIITZI/Tasks/file.txt"), 0);
        System.out.println(point.toString());
        cube.set(Paths.get("d://NIITZI/Tasks/file.txt"), 8);
        System.out.println(cube.toString());
        System.out.println(CubeMethods.surfaceArea(cube) + " " + CubeMethods.checkCube(cube) + " " + CubeMethods.checkFaces(cube));
        cube1.set(Paths.get("d://NIITZI/Tasks/file.txt"), 16);
        System.out.println(cube1.toString());
        System.out.println(CubeMethods.surfaceArea(cube1) + " " + CubeMethods.checkCube(cube1) + " " + CubeMethods.checkFaces(cube1));

        cube2.set(Paths.get("d://NIITZI/Tasks/file.txt"), 24);
        System.out.println(cube2.toString());
        System.out.println(CubeMethods.surfaceArea(cube2) + " " + CubeMethods.volume(cube2) + " " + CubeMethods.checkCube(cube2) + " " + CubeMethods.checkFaces(cube2));
        System.out.println(CubeMethods.volumeRatioDissection(cube2));
    }
}