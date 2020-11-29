public class MatHang {
    private int maMh;
    private String tenMh;
    private String nhomMh;
    private double gia;

    public MatHang(int maMh, String tenMh, String nhomMh, double gia) {
        this.maMh = maMh;
        this.tenMh = tenMh;
        this.nhomMh = nhomMh;
        this.gia = gia;
    }

    public int getMaMh() {
        return maMh;
    }

    public void setMaMh(int maMh) {
        this.maMh = maMh;
    }

    public String getTenMh() {
        return tenMh;
    }

    public void setTenMh(String tenMh) {
        this.tenMh = tenMh;
    }

    public String getNhomMh() {
        return nhomMh;
    }

    public void setNhomMh(String nhomMh) {
        this.nhomMh = nhomMh;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

}
