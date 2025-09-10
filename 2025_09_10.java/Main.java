import java.util.*;

class TaiKhoan {
    private String soTaiKhoan;
    private String chuTaiKhoan;
    private double soDu;
    private static double laiSuat = 0.03; 
    public TaiKhoan(String soTaiKhoan, String chuTaiKhoan, double soDu) {
        this.soTaiKhoan = soTaiKhoan;
        this.chuTaiKhoan = chuTaiKhoan;
        this.soDu = soDu;
    }
    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }

    public double getSoDu() {
        return soDu;
    }
    public void napTien(double soTien) {
        if (soTien > 0) {
            soDu += soTien;
            System.out.println("Nạp " + soTien + " vào tài khoản " + soTaiKhoan + " thành công.");
        }
    }
    public void rutTien(double soTien) {
        if (soTien > 0 && soTien <= soDu) {
            soDu -= soTien;
            System.out.println("Rút " + soTien + " từ tài khoản " + soTaiKhoan + " thành công.");
        } else {
            System.out.println("Số dư không đủ hoặc số tiền rút không hợp lệ.");
        }
    }
    public void tinhLai() {
        double tienLai = soDu * laiSuat;
        soDu += tienLai;
        System.out.println("Cộng lãi " + tienLai + " vào tài khoản " + soTaiKhoan);
    }
    public void hienThi() {
        System.out.println("Số TK: " + soTaiKhoan +
                ", Chủ TK: " + chuTaiKhoan +
                ", Số dư: " + soDu);
    }
    public static void thayDoiLaiSuat(double laiSuatMoi) {
        laiSuat = laiSuatMoi;
    }

    public static double getLaiSuat() {
        return laiSuat;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<TaiKhoan> dsTaiKhoan = new ArrayList<>();
        dsTaiKhoan.add(new TaiKhoan("001", "Nguyen Van A", 5000));
        dsTaiKhoan.add(new TaiKhoan("002", "Tran Thi B", 10000));
        dsTaiKhoan.add(new TaiKhoan("003", "Le Van C", 2000));
        System.out.println("== Danh sách tài khoản ban đầu ==");
        for (TaiKhoan tk : dsTaiKhoan) {
            tk.hienThi();
        }
        dsTaiKhoan.get(0).napTien(2000);
        dsTaiKhoan.get(1).rutTien(3000);
        dsTaiKhoan.get(2).tinhLai();
        System.out.println("\n== Danh sách sau giao dịch ==");
        for (TaiKhoan tk : dsTaiKhoan) {
            tk.hienThi();
        }
        String soTKCanTim = "002";
        System.out.println("\n== Tìm kiếm tài khoản số " + soTKCanTim + " ==");
        for (TaiKhoan tk : dsTaiKhoan) {
            if (tk.getSoTaiKhoan().equals(soTKCanTim)) {
                tk.hienThi();
            }
        }
        dsTaiKhoan.sort((a, b) -> Double.compare(b.getSoDu(), a.getSoDu()));
        System.out.println("\n== Danh sách sắp xếp theo số dư giảm dần ==");
        for (TaiKhoan tk : dsTaiKhoan) {
            tk.hienThi();
        }
    }
}
