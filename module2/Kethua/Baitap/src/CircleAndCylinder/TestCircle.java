package CircleAndCylinder;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println("Default: "+ circle);

        circle = new Circle(3.5, "indigo");
        System.out.println("Call Circle: " + circle);

        circle.setRadius(5.0);
        circle.setColor("blue");
        System.out.println(circle + " Perimeter: " + circle.getPerimeter() + ", Area: "+circle.getArea());
    }
}
