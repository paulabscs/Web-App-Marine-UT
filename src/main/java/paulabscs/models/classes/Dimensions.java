package paulabscs.models.classes;

/* all fields are required here as the client doesn't 
   have access to modifier api (readonly) */
public class Dimensions {

    private final double length; // Length of the dimension
    private final double width;  // Width of the dimension
    private final double height; // Height of the dimension

    public Dimensions(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
