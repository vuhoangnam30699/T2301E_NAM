import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    private String customerName;
    private LocalDateTime transactionTime;
    private ArrayList<LineItem> lineItems = new ArrayList<>();

    public Order() {

    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(LocalDateTime transactionTime) {
        this.transactionTime = transactionTime;
    }

    public ArrayList<LineItem> getLineItems() {
        return lineItems;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customerName='" + customerName + '\'' +
                ", transactionTime=" + transactionTime +
                ", lineItems=" + lineItems +
                '}';
    }

    public Double cost() {
        Double totalCost = 0.0;
        for (LineItem item : lineItems) {
            totalCost += item.cost();
        }
        return totalCost;
    }

    public boolean addProduct(Product product, Integer quantity) {
        if (quantity <= product.getQuantity()) {
            LineItem item = new LineItem(product, quantity);
            lineItems.add(item);
            product.setQuantity(product.getQuantity() - quantity);
            return true;
        } else {
            return false;
        }
    }

}
