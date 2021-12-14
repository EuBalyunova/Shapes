package entity;

public class ShapesFactory {
    public Shape getShape(ShapeType type) {
        Shape toReturn = null;
        switch (type) {
            case POINT:
                toReturn = new Point();
                break;
            case CUBE:
                toReturn = new Cube();
                break;
            //	 default:

        }
        return toReturn;
    }
}