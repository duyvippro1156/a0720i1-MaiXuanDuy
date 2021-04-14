package List;

public class Main {
    public static void main(String[] args) {
        Student a = new Student(1,"DUY");
        Student b = new Student(2,"NAM");
        Student c = new Student(3,"THẾ");
        Student d = new Student(4,"SÁNG");
        Student e = new Student(5,"VIỆT");
        Student f = new Student(6,"VŨ");

        MyArrayList<Student> studentMyArrayList = new MyArrayList<>();
        studentMyArrayList.add(a);
        studentMyArrayList.add(b);
        studentMyArrayList.add(c);
        studentMyArrayList.add(d);
        studentMyArrayList.add(e);
        studentMyArrayList.add(f,2);

        for (int i = 0; i< studentMyArrayList.size(); i++){
            Student student = (Student) studentMyArrayList.elements[i];
            System.out.println(student.getId());
            System.out.println(student.getName());
        }
        System.out.println("Size: " + studentMyArrayList.size());
    }
}
