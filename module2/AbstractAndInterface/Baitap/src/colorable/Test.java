package colorable;

import resizeable.Circle;
import resizeable.Rectangle;
import resizeable.Shape;

public class Test {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(10);
        shapes[1] = new Rectangle(10, 20);
        shapes[2] = new Square(10);
        for (Shape shape : shapes){
            if (shape instanceof Colorable){
                ((Colorable)shape).howToColor();
            }
        }
    }
}