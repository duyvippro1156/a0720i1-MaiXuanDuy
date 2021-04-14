package models;

public abstract class Stk {

    private String maso;
    private String maKH;
    private String ngaymoso;
    private String ngaybatdau;
    private String sotiengui;
    private String laisuat;

    public Stk() {
    }

    public Stk(String maso, String maKH, String ngaymoso, String ngaybatdau, String sotiengui, String laisuat) {
        this.maso = maso;
        this.maKH = maKH;
        this.ngaymoso = ngaymoso;
        this.ngaybatdau = ngaybatdau;
        this.sotiengui = sotiengui;
        this.laisuat = laisuat;
    }

    public String getMaso() {
        return maso;
    }

    public void setMaso(String maso) {
        this.maso = maso;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getNgaymoso() {
        return ngaymoso;
    }

    public void setNgaymoso(String ngaymoso) {
        this.ngaymoso = ngaymoso;
    }

    public String getNgaybatdau() {
        return ngaybatdau;
    }

    public void setNgaybatdau(String ngaybatdau) {
        this.ngaybatdau = ngaybatdau;
    }


    public String getSotiengui() {
        return sotiengui;
    }

    public void setSotiengui(String sotiengui) {
        this.sotiengui = sotiengui;
    }

    public String getLaisuat() {
        return laisuat;
    }

    public void setLaisuat(String laisuat) {
        this.laisuat = laisuat;
    }


    @Override
    public String toString() {
        return "stk_daihan{" +
                "maso='" + maso + '\'' +
                ", maKH='" + maKH + '\'' +
                ", ngaymoso='" + ngaymoso + '\'' +
                ", ngaybatdau='" + ngaybatdau + '\'' +
                ", sotiengui='" + sotiengui + '\'' +
                ", laisuat='" + laisuat + '\'' +
                '}';
    }
}


