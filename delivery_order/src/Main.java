import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        // Initialize products
        Product tomato = new Product("F523", "Tomato", "Food", 1.5, 589);
        Product zaraShirt = new Product("A763", "Zara shirt", "Appearance", 12.0, 90);
        Product kitchenTable = new Product("H320", "Kitchen table", "Household", 299.0, 13);
        Product iPhone = new Product("E092", "iPhone", "Electronic", 1000.0, 4);
        Product football = new Product("S108", "Football", "Sport", 19.9, 2);

        // Create a new Order for "Mike Tyson"
        Order order = new Order();
        order.setCustomerName("Mike Tyson");
        order.setTransactionTime(LocalDateTime.of(2023, 8, 8, 11, 30));

        // Add products to the order
        addProductToOrder(order, tomato, 5);
        addProductToOrder(order, iPhone, 2);
        addProductToOrder(order, football, 4);

        // Print information and total cost of the order
        System.out.println("Order for Mike Tyson:");
        printOrderInfo(order);

        // Create a new Delivery Order for "Chris Evans"
        DeliveryOrder deliveryOrder = new DeliveryOrder();
        deliveryOrder.setCustomerName("Chris Evans");
        deliveryOrder.setTransactionTime(LocalDateTime.of(2023, 8, 9, 13, 14));
        deliveryOrder.setAddress("123 Cau Giay");

        // Add products to the delivery order
        addProductToOrder(deliveryOrder, zaraShirt, 3);
        addProductToOrder(deliveryOrder, iPhone, 3);

        // Print information of the delivery order
        System.out.println("\nDelivery Order for Chris Evans:");
        printOrderInfo(deliveryOrder);
    }

    public static void addProductToOrder(Order order, Product product, int quantity) {
        System.out.println("\nAdding " + quantity + " " + product.getName() + " to the order...");

        try{
            order.addProduct(product, quantity);
            System.out.println("Added successfully. Total cost of order: $" + order.cost());
        }
        catch (OutOfStockException e) {
//            e.printStackTrace();
            System.out.println("Failed to add due to insufficient quantity.");
        }
//        boolean success = order.addProduct(product, quantity);
//        if (success) {
//            System.out.println("Added successfully. Total cost of order: $" + order.cost());
//        } else {
//            System.out.println("Failed to add due to insufficient quantity.");
//        }
    }

    public static void printOrderInfo(Order order) {
        System.out.println(order);
        System.out.println("Total cost of order: $" + order.cost());
    }
}
