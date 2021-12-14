package entity;

import java.nio.file.Path;

public class Cube implements Shape {
    public String id;
    public Point[] point = new Point[8];

    public Cube() {}

    @Override
    public void set(Path path, int n) {
        id = "";
        for(int i=0; i<8; i++) {
            point[i] = new Point();
            point[i].set(path, n+i);
            id = id + point[i].x + "." + point[i].y + "." + point[i].z + "..";
        }
        id = id.substring(0, id.length()-2);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cube other = (Cube) obj;
        if (this.id != other.id) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "id - " + id + "\nA1 (" + point[0].x + "; " + point[0].y + "; " + point[0].z +
                ")\tB1 (" + point[1].x + "; " + point[1].y + "; " + point[1].z +
                ")\tC1 (" + point[2].x + "; " + point[2].y + "; " + point[2].z +
                ")\tD1 (" + point[3].x + "; " + point[3].y + "; " + point[3].z +
                ")\nA2 (" + point[4].x + "; " + point[4].y + "; " + point[4].z +
                ")\tB2 (" + point[5].x + "; " + point[5].y + "; " + point[5].z +
                ")\tC2 (" + point[6].x + "; " + point[6].y + "; " + point[6].z +
                ")\tD2 (" + point[7].x + "; " + point[7].y + "; " + point[7].z + ")";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 2 * hash + this.point[0].x + this.point[0].y + this.point[0].z;
        hash = 3 * hash + this.point[1].x + this.point[1].y + this.point[1].z;
        hash = 4 * hash + this.point[2].x + this.point[2].y + this.point[2].z;
        hash = 5 * hash + this.point[3].x + this.point[3].y + this.point[3].z;
        hash = 6 * hash + this.point[4].x + this.point[4].y + this.point[4].z;
        hash = 7 * hash + this.point[5].x + this.point[5].y + this.point[5].z;
        hash = 8 * hash + this.point[6].x + this.point[6].y + this.point[6].z;
        hash = 9 * hash + this.point[7].x + this.point[7].y + this.point[7].z;
        return hash;
    }
}