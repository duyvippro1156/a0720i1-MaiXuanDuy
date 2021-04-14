package Triangle;

public class test {
    public static void main(String[] args) {
        Triangle t1 = new Triangle();
        System.out.println(t1);
        Triangle t2 = new Triangle(12, 4, 4);
        System.out.println(t2);
        Triangle t3 = new Triangle("blue", false, 10, 5, 5);
        System.out.println(t3 + ", Chu vi: "+t3.getPerimeter()+ ", Diện tích" + t3.getArea());
        Triangle t4 = new Triangle();
        t4.setSide1(8);
        t4.setSide2(8);
        t4.setSide3(8);
        System.out.println(t4 + ", Chu vi: "+t4.getPerimeter()+ ", Diện tích" + t4.getArea());
    }
}
