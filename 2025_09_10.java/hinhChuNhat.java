import java.util.Scanner;
class hinhChuNhat_ {
    private double chieuDai;
    private double chieuRong;
    public hinhChuNhat_(double chieuDai, double chieuRong){
        this.chieuDai = chieuDai;
        this.chieuRong = chieuRong;
    }
    public double tinhChuVi(){
        return (this.chieuDai + this.chieuRong) * 2;
    }
    public double tinhDienTich(){
        return this.chieuDai * this.chieuRong;
    }
    public void Display() {
        System.out.println("Chieu dai: " + this.chieuDai);
        System.out.println("Chieu rong: " + this.chieuRong);
        System.out.println("Chu vi: " + tinhChuVi());
        System.out.println("Dien tich: " + tinhDienTich());
    }
}
public class hinhChuNhat {
    public static void main(String[] args) {
        hinhChuNhat_ hcn1 = new hinhChuNhat_(5, 3);
        hinhChuNhat_ hcn2 = new hinhChuNhat_(4.5, 2.5);
        hinhChuNhat_ hcn3 = new hinhChuNhat_(6.5,2.5 );
        hcn1.Display();
        hcn2.Display();
        hcn3.Display();
        
    }
}
