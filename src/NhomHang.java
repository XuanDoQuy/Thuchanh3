import java.util.Vector;

public class NhomHang {
    private String ten;
    private Vector<MatHang> dsHang;

    public NhomHang(String ten) {
        this.ten = ten;
        dsHang = new Vector<>();
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Vector<MatHang> getDsHang() {
        return dsHang;
    }

    public void setDsHang(Vector<MatHang> dsHang) {
        this.dsHang = dsHang;
    }
}
