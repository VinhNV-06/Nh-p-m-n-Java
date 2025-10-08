import java.util.*;
interface PaymentMethod {
    void pay(double amount);
}
class CashPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán tiền mặt thành công. Số tiền: " + amount);
    }
}

class CreditCardPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán bằng thẻ tín dụng thành công. Số tiền: " + amount);
    }
}

class MomoPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán bằng ví Momo thành công. Số tiền: " + amount);
    }
}
abstract class Product {
    protected String productId;
    protected String name;
    protected double price;

    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public abstract String getInfo();
}

class ElectronicProduct extends Product {
    private String imei;
    private int warrantyPeriod;

    public ElectronicProduct(String id, String name, double price, String imei, int warranty) {
        super(id, name, price);
        this.imei = imei;
        this.warrantyPeriod = warranty;
    }

    @Override
    public String getInfo() {
        return "[Điện tử] " + name + " - IMEI: " + imei + ", BH: " + warrantyPeriod + " tháng";
    }
}

class FoodProduct extends Product {
    private String expiryDate;

    public FoodProduct(String id, String name, double price, String expiryDate) {
        super(id, name, price);
        this.expiryDate = expiryDate;
    }

    @Override
    public String getInfo() {
        return "[Thực phẩm] " + name + " - HSD: " + expiryDate;
    }
}
class Order {
    private String customerName;
    private List<Product> products = new ArrayList<>();
    private PaymentMethod paymentMethod;

    public Order(String customerName, PaymentMethod paymentMethod) {
        this.customerName = customerName;
        this.paymentMethod = paymentMethod;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double getTotalAmount() {
        double total = 0;
        for (Product p : products) total += p.getPrice();
        return total;
    }

    public void checkout() {
        double amount = getTotalAmount();
        System.out.println("Khách hàng: " + customerName + ". Tổng tiền: " + amount);
        paymentMethod.pay(amount);
    }
}
public class Main {
    public static void main(String[] args) {
        Product p1 = new ElectronicProduct("E01", "Tai nghe", 200000, "123456789", 12);
        Product p2 = new FoodProduct("F01", "Bánh quy", 50000, "10/10/2025");

        Order order1 = new Order("Nguyễn Văn A", new CashPayment());
        order1.addProduct(p1);
        order1.addProduct(p2);
        order1.checkout();

        System.out.println();

        Order order2 = new Order("Nguyễn Văn B", new CreditCardPayment());
        order2.addProduct(new ElectronicProduct("E02", "Điện thoại", 4500000, "999888777", 24));
        order2.checkout();
    }
}
