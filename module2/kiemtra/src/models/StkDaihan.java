package models;


public class StkDaihan extends Stk {
    private String kyhan;
    private String uudai;

    public StkDaihan() {
    }

    public StkDaihan(String maso, String maKH, String ngaymoso, String ngaybatdau, String sotiengui, String laisuat, String kyhan, String uudai) {
        super(maso, maKH, ngaymoso, ngaybatdau, sotiengui, laisuat);
        this.kyhan = kyhan;
        this.uudai = uudai;
    }

    public String getKyhan() {
        return kyhan;
    }

    public void setKyhan(String kyhan) {
        this.kyhan = kyhan;
    }

    public String getUudai() {
        return uudai;
    }

    public void setUudai(String uudai) {
        this.uudai = uudai;
    }

    @Override
    public String toString() {
        return "stk_daihan{" +
                "kyhan='" + kyhan + '\'' +
                ", uudai='" + uudai + '\'' +
                "} " + super.toString();
    }
}
