import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        Product tomato = new Product("F523", "Tomato", "Food", 1.5, 589);
        Product zaraShirt = new Product("A763", "Zara shirt", "Appearance", 12.0, 90);
        Product kitchenTable = new Product("H320", "Kitchen table", "Household", 299.0, 13);
        Product iPhone = new Product("E092", "IPhone", "Electronic", 1000.0, 4);
        Product football = new Product("S108", "Football", "Sport", 19.9, 2);

        Order order = new Order();
        order.setCustomerName("Mike Tyson");
        order.setTransactionTime(LocalDateTime.of(2023, 8, 8, 11, 30, 0));



        boolean added = order.addProduct(tomato, 5);
        System.out.println("Add 5 Tomato: " + (added ? "Success" : "Fail"));
        System.out.println("Total cost: " + order.cost());

        added = order.addProduct(iPhone, 2);
        System.out.println("Add 2 IPhone: " + (added ? "Success" : "Fail"));
        System.out.println("Total cost: " + order.cost());

        added = order.addProduct(football, 4);
        System.out.println("Add 4 Football: " + (added ? "Success" : "Fail"));
        System.out.println("Total cost: " + order.cost());

        System.out.println("\nOrder information:");
        System.out.println(order + "\n\n");



        DeliveryOrder deliveryOrder = new DeliveryOrder();
        deliveryOrder.setCustomerName("Chris Evans");
        deliveryOrder.setTransactionTime(LocalDateTime.of(2023, 8, 9, 13, 14, 0));
        deliveryOrder.setAddress("123 Cau Giay");

        boolean deliveryAdded = deliveryOrder.addProduct(zaraShirt, 3);
        System.out.println("Add 3 Zara shirt: " + (deliveryAdded ? "Success" : "Fail"));
        System.out.println("Total cost: " + deliveryOrder.cost());

        deliveryAdded = deliveryOrder.addProduct(iPhone, 3);
        System.out.println("Add 3 IPhone: " + (deliveryAdded ? "Success" : "Fail"));
        System.out.println("Total cost: " + deliveryOrder.cost());

        System.out.println("\nDelivery Order information:");
        System.out.println(deliveryOrder);
    }
}