import java.util.Scanner;

public class Phuongtrinhbac2 {
    int A;
    int B;
    int C;
    public Phuongtrinhbac2() {
    }
    public Phuongtrinhbac2(int A, int B, int C) {
            this.A = A;
            this.B = B;
            this.C = C;
        }


        public int getA() {
            return A;
        }

        public void setA(int A) {
            this.A = A;
        }

        public int getB() {
            return B;
        }

        public void setB(int B) {
            this.B = B;
        }

        public int getC() {
            return C;
        }

        public void setC(int C) {
            this.C = C;
        }

        public float getDiscriminant() {
            float delta = (B * B) - (4 * A * C);
            return delta;
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int A;
            int B;
            int C;
            float x1,x2;
            do {
                System.out.println("Nhập vào a:");
                A = scanner.nextInt();
                if (A < 0){
                    System.out.println("Vui lòng nhập a lớn hơn 0");
                }

            } while (A < 0);
            System.out.println("Nhập vào b:");
            B = scanner.nextInt();
            System.out.println("Nhập vào c:");
            C = scanner.nextInt();
            Phuongtrinhbac2 quadraticEquation = new Phuongtrinhbac2(A, B, C);
            float delta = quadraticEquation.getDiscriminant();
            System.out.println("Delta hiện tại là: " + delta);
            if(A==0)
                if(B==0)
                    if(C==0)
                    {
                        System.out.println("Phuong trinh vo so nghiem");
                    }
                    else
                    {
                        System.out.println("Phuong trinh vo nghiem");
                    }
                else //(b!=0)
                {
                    System.out.println("Phuong trinh co nghiem="+ (-C/B));
                }
            else
            {
                if (delta<0){
                    System.out.println("Phuong trinh vo nghiem");
                }
                else
                if (delta==0)
                {
                    x1 = -B/(2*A);
                    System.out.println("Phuong trinh co nghiem kep ="+x1);
                }
                else //(del>0)
                {
                    x1=(float)(-B+Math.sqrt(delta))/(2*A);
                    x2=(float)(-B-Math.sqrt(delta))/(2*A);
                    System.out.println("Phuong trinh 2 nghiem :\n x1="+x1+" \n x2="+x2);
                }
            }
        }
}
