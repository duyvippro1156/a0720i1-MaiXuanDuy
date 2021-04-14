package models;

public class StkNganhanCothoihan extends Stk {
    private String kyhan;


    public StkNganhanCothoihan(){
    }

    public StkNganhanCothoihan(String maso, String maKH, String ngaymoso, String ngaybatdau, String sotiengui, String laisuat, String kyhan) {
        super(maso, maKH, ngaymoso, ngaybatdau, sotiengui, laisuat);
        this.kyhan = kyhan;
    }

    public String getKyhan() {
        return kyhan;
    }

    public void setKyhan(String kyhan) {
        this.kyhan = kyhan;
    }

    @Override
    public String toString() {
        return "stk_nganhan_cothoihan{" +
                "kyhan='" + kyhan + '\'' +
                "} " + super.toString();
    }
}
