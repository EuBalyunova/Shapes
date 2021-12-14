package entity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class Point implements Shape {
    public int x, y, z;

    public Point() {}

    @Override
    public void set(Path path, int n) {
        List<String> list = new ArrayList<>();

        try (Stream<String> lineStream = Files.lines(path)) {

            list = lineStream.collect(Collectors.toList());

        } catch (IOException e) {
        }

        for (int i=0; i<list.size();i++) {
            String str = list.get(i);
            if (str.indexOf("(") != 0 || str.indexOf(")") != str.length()-1) {
                list.remove(i);
                i--;
                continue;
            }
            //проверка чтобы было 2 ;
            int b=0;
            for (int j=1; j<str.length()-1;j++) {
                if (str.charAt(j) == ';') {
                    b++;
                }
            }
            if (b!=2) {
                list.remove(i);
                i--;
                continue;
            }
            for (int j=1; j<str.length()-1;j++) {
                if(str.charAt(j) != ';' && str.charAt(j) != '-' && str.charAt(j) != '0' && str.charAt(j) != '1' &&
                        str.charAt(j) != '2' && str.charAt(j) != '3' && str.charAt(j) != '4' && str.charAt(j) != '5' &&
                        str.charAt(j) != '6' && str.charAt(j) != '7' && str.charAt(j) != '8' && str.charAt(j) != '9') {
                    list.remove(i);
                    i--;
                    break;
                }
            }
        }

        String str = list.get(n);
        for (int i=0; i< str.length(); i++) {
            if (str.indexOf("(")+1 != str.indexOf(";")) {
                String strx = str.substring(str.indexOf("(")+1, str.indexOf(";"));
                this.x = Integer.parseInt(strx.trim());
            } else {
                x=0;
            }
            if (str.indexOf(";")+1 != str.lastIndexOf(";")) {
                String stry = str.substring(str.indexOf(";")+1, str.lastIndexOf(";"));
                this.y = Integer.parseInt(stry.trim());
            } else {
                y=0;
            }
            if (str.lastIndexOf(";")+1 != str.indexOf(")")) {
                String strz = str.substring(str.lastIndexOf(";") + 1, str.indexOf(")"));
                this.z = Integer.parseInt(strz);
            } else {
                z=0;
            }
        }
    }

    @Override
    public String toString() {
        return "x = " + x + ", y = " + y + ", z = " + z;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Point other = (Point) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        if (this.z != other.z) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.x;
        hash = 97 * hash + this.y;
        hash = 97 * hash + this.z;
        return hash;
    }
}
