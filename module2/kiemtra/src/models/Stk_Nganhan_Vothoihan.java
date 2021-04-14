package models;

public class Stk_Nganhan_Vothoihan extends Stk {

    public Stk_Nganhan_Vothoihan() {
    }

    public Stk_Nganhan_Vothoihan(String maso, String maKH, String ngaymoso, String ngaybatdau, String sotiengui, String laisuat) {
        super(maso, maKH, ngaymoso, ngaybatdau, sotiengui, laisuat);
    }

    @Override
    public String toString() {
        return "stk_nganhan_vothoihan{ " + super.toString();
    }
}
