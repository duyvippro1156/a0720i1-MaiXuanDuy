package Protected;

import Default.Circle;

public class NewCircle extends Circle {
    public void print() {
        System.out.print(this.getRadius() + " - " + this.getColor());
    }
}