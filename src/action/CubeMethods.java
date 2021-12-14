package action;
import entity.Shape;
import entity.Cube;
import static java.lang.Math.sqrt;
import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class CubeMethods {

    public static double surfaceArea(Shape objShape) {
        if (checkPrism(objShape)==true) {
            final Cube obj = (Cube) objShape;
            double a = sqrt(pow((obj.point[1].x-obj.point[0].x),2) + pow((obj.point[1].z-obj.point[0].z),2)),
                    b = sqrt(pow((obj.point[2].x-obj.point[1].x),2) + pow((obj.point[2].z-obj.point[1].z),2)),
                    c = sqrt(pow((obj.point[3].x-obj.point[2].x),2) + pow((obj.point[3].z-obj.point[2].z),2)),
                    d = sqrt(pow((obj.point[0].x-obj.point[3].x),2) + pow((obj.point[0].z-obj.point[3].z),2));
            double p = (a+b+c+d)/2;
            double h = abs((obj.point[4].y-obj.point[0].y));
            return 2*sqrt(abs((p-a)*(p-b)*(p-c)*(p-d))) + (a+b+c+d)*h;
        }
        return 0;
    }

    public static double volume(Shape objShape) {
        if (checkPrism(objShape)==true) {
            final Cube obj = (Cube) objShape;
            double a = sqrt(pow((obj.point[1].x-obj.point[0].x),2) + pow((obj.point[1].z-obj.point[0].z),2)),
                    b = sqrt(pow((obj.point[2].x-obj.point[1].x),2) + pow((obj.point[2].z-obj.point[1].z),2)),
                    c = sqrt(pow((obj.point[3].x-obj.point[2].x),2) + pow((obj.point[3].z-obj.point[2].z),2)),
                    d = sqrt(pow((obj.point[0].x-obj.point[3].x),2) + pow((obj.point[0].z-obj.point[3].z),2));
            double p = (a+b+c+d)/2;
            double h = abs((obj.point[4].y-obj.point[0].y));
            return sqrt(abs((p-a)*(p-b)*(p-c)*(p-d)))*h;
        }
        return 0;
    }

    public static boolean checkCube(Shape objShape) {
        if (checkPrism(objShape)==true) {
            final Cube obj = (Cube) objShape;
            double a = sqrt(pow((obj.point[1].x-obj.point[0].x),2) + pow((obj.point[1].z-obj.point[0].z),2)),
                    b = sqrt(pow((obj.point[2].x-obj.point[1].x),2) + pow((obj.point[2].z-obj.point[1].z),2)),
                    c = sqrt(pow((obj.point[3].x-obj.point[2].x),2) + pow((obj.point[3].z-obj.point[2].z),2)),
                    d = sqrt(pow((obj.point[0].x-obj.point[3].x),2) + pow((obj.point[0].z-obj.point[3].z),2)),
                    h = abs((obj.point[4].y-obj.point[0].y));
            if (a==h && b==h && c==h && d==h) {
                return true;
            }
        }
        return false;
    }

    public static String volumeRatioDissection(Shape objShape) {
        String result = "false";
        if (checkParallelepiped(objShape)==true) {
            final Cube obj = (Cube) objShape;
            result = "";
            //XY
            if (obj.point[0].z < 0 && obj.point[2].z > 0) {
                if (obj.point[1].z < 0) {
                    result = "XY - " + obj.point[3].z + "/" + -obj.point[0].z + "\n";
                } else {
                    result = "XY - " + obj.point[1].z + "/" + -obj.point[0].z + "\n";
                }
            } else
            if (obj.point[2].z < 0 && obj.point[0].z > 0) {
                if (obj.point[1].z < 0) {
                    result = "XY - " + obj.point[3].z + "/" + -obj.point[2].z + "\n";
                } else {
                    result = "XY - " + obj.point[1].z + "/" + -obj.point[2].z + "\n";
                }
            }
            //YZ
            if (obj.point[0].x < 0 && obj.point[2].x > 0) {
                if (obj.point[1].x < 0) {
                    result = result + "YZ - " + obj.point[3].x + "/" + -obj.point[0].x + "\n";
                } else {
                    result = result + "YZ - " + obj.point[1].x + "/" + -obj.point[0].x + "\n";
                }
            } else
            if (obj.point[2].x < 0 && obj.point[0].x > 0) {
                if (obj.point[1].x < 0) {
                    result = result + "YZ - " + obj.point[3].x + "/" + -obj.point[2].x + "\n";
                } else {
                    result = result + "YZ - " + obj.point[1].x + "/" + -obj.point[2].x + "\n";
                }
            }
            //XZ
            if (obj.point[0].y < 0 && obj.point[4].y >0) {
                result = result + "XZ - " + obj.point[4].y + "/" + -obj.point[0].y + "\n";
            } else
            if (obj.point[4].y < 0 && obj.point[0].y >0) {
                result = result + "XZ - " + obj.point[0].y + "/" + -obj.point[4].y + "\n";
            }
        }
        return result;
    }

    public static boolean checkFaces(Shape objShape) {
        if (checkPrism(objShape)==true) {
            final Cube obj = (Cube) objShape;
            //XZ
            if (obj.point[0].y==0 || obj.point[4].y==0) {
                return true;
            }
            //XY
            if ((obj.point[0].z==0 && obj.point[1].z==0) || (obj.point[1].z==0 && obj.point[2].z==0) ||
                    (obj.point[2].z==0 && obj.point[3].z==0) || (obj.point[3].z==0 && obj.point[0].z==0)) {
                return true;
            }
            //YZ
            if ((obj.point[0].x==0 && obj.point[1].x==0) || (obj.point[1].x==0 && obj.point[2].x==0) ||
                    (obj.point[2].x==0 && obj.point[3].x==0) || (obj.point[3].x==0 && obj.point[0].x==0)) {
                return true;
            }
        }
        return false;
    }



    private static boolean checkPrism(Shape objShape) {
        final Cube obj = (Cube) objShape;
        if (obj.point[0].x != obj.point[4].x || obj.point[0].z != obj.point[4].z ||
                obj.point[1].x != obj.point[5].x || obj.point[1].z != obj.point[5].z ||
                obj.point[2].x != obj.point[6].x || obj.point[2].z != obj.point[6].z ||
                obj.point[3].x != obj.point[7].x || obj.point[3].z != obj.point[7].z) {
            return false;
        }
        if (obj.point[0].y != obj.point[1].y || obj.point[0].y != obj.point[2].y ||
                obj.point[0].y != obj.point[2].y || obj.point[0].y != obj.point[3].y) {
            return false;
        }
        if (obj.point[4].y != obj.point[5].y || obj.point[4].y != obj.point[6].y ||
                obj.point[4].y != obj.point[6].y || obj.point[4].y != obj.point[7].y) {
            return false;
        }
        return true;
    }

    private static boolean checkParallelepiped(Shape objShape) {
        final Cube obj = (Cube) objShape;
        if (checkPrism(obj)==true) {
            if (obj.point[0].x==obj.point[1].x && obj.point[2].x==obj.point[3].x &&
                    obj.point[1].z==obj.point[2].z && obj.point[0].z==obj.point[3].z) {
                return true;
            } else
            if (obj.point[0].x==obj.point[3].x && obj.point[1].x==obj.point[2].x &&
                    obj.point[0].z==obj.point[1].z && obj.point[2].z==obj.point[3].z) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
