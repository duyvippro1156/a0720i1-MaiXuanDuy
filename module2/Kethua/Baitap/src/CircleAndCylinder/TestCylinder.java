package CircleAndCylinder;

public class TestCylinder {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder();
        System.out.println("Default "+cylinder);

        cylinder = new Cylinder(5.0,"blue",10.0);
        System.out.println("Call "+cylinder);

        cylinder.setRadius(3.5);
        cylinder.setColor("yellow");
        cylinder.setHeight(7.0);
        System.out.println(cylinder + " Perimeter: " + cylinder.getPerimeter() + " Area: "+ cylinder.getArea() + " Volumetric: "+cylinder.getVolumetric());
    }


}
