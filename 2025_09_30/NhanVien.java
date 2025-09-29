class nnhanVien {
    protected String ten;
    protected int tuoi;
    protected double luong;
    public nnhanVien(String ten, int tuoi, double luong) {
        this.ten = ten;
        this.tuoi = tuoi;
        this.luong = luong;
    }
    public double tinhLuong() {
        return luong;
    }
    public void hienThi() {
        System.out.println("Ten: " + ten);
        System.out.println("Tuoi: " + tuoi);
        System.out.println("Luong: " + tinhLuong());
    }
}
class nhanVienVanPhong extends nnhanVien {
    private int soNgayLamViec;
    private static final double LUONG_CO_BAN = 100;
    public nhanVienVanPhong(String ten, int tuoi, int soNgayLamViec) {
        super(ten, tuoi, 0);
        this.soNgayLamViec = soNgayLamViec;
    }
    @Override
    public double tinhLuong() {
        return soNgayLamViec * LUONG_CO_BAN;
    }
}
class NhanVienKiThuat extends nnhanVien {
    private int gioLamViec;
    private double tienCongTheoGio;
    public NhanVienKiThuat(String ten, int tuoi, int gioLamViec, double tienCongTheoGio) {
        super(ten, tuoi, 0);
        this.gioLamViec = gioLamViec;
        this.tienCongTheoGio = tienCongTheoGio;
    }
    @Override
    public double tinhLuong() {
        return gioLamViec * tienCongTheoGio;
    }
}
public class NhanVien {
    public static void main(String[] args) {
        nhanVienVanPhong nv1 = new nhanVienVanPhong("Nguyen Van A", 30, 22);
        NhanVienKiThuat nv2 = new NhanVienKiThuat("Tran Thi B", 28, 160, 50);
        nv1.hienThi();
        nv2.hienThi();
    }
}
