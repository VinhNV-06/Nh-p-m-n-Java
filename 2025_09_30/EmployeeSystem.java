
interface EmailSender {
    void sendEmail();
}
interface Programmer {
    void code();
}
interface Salesperson {
    void sell();
}
class OfficeEmployee implements EmailSender {
    private String name;
    public OfficeEmployee(String name) {
        this.name = name;
    }
    @Override
    public void sendEmail() {
        System.out.println(name + " đang gửi email cho khách hàng.");
    }
}
class TechnicalEmployee implements EmailSender, Programmer {
    private String name;

    public TechnicalEmployee(String name) {
        this.name = name;
    }
    @Override
    public void sendEmail() {
        System.out.println(name + " đang gửi email báo cáo tiến độ.");
    }
    @Override
    public void code() {
        System.out.println(name + " đang lập trình một ứng dụng mới.");
    }
}
class SalesEmployee implements EmailSender, Salesperson {
    private String name;

    public SalesEmployee(String name) {
        this.name = name;
    }

    @Override
    public void sendEmail() {
        System.out.println(name + " đang gửi email quảng cáo sản phẩm.");
    }

    @Override
    public void sell() {
        System.out.println(name + " đang bán sản phẩm cho khách hàng.");
    }
}
public class EmployeeSystem {
    public static void main(String[] args) {
        OfficeEmployee nv1 = new OfficeEmployee("Nguyen Van A");
        TechnicalEmployee nv2 = new TechnicalEmployee("Tran Thi B");
        SalesEmployee nv3 = new SalesEmployee("Le Van C");

        // Sử dụng chức năng của từng loại nhân viên
        nv1.sendEmail();

        nv2.sendEmail();
        nv2.code();

        nv3.sendEmail();
        nv3.sell();
    }
}
