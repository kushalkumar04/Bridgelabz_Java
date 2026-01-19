
package objectorientedprogramming.inheritance.multilevelinheritence;
/*
 * Online Retail Order Management System
 *
 * Demonstrates multilevel inheritance.
 * Order is the base class.
 * ShippedOrder extends Order.
 * DeliveredOrder extends ShippedOrder.
 *
 * Each level adds more information and behavior.
 */

class Order {

    // Common order attributes
    int orderId;
    String orderDate;

    // Constructor
    Order(int orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    // Method to return order status
    String getOrderStatus() {
        return "Order Placed";
    }
}

/*
 * ShippedOrder class
 *
 * Extends Order and adds shipping-related details.
 */
class ShippedOrder extends Order {

    String trackingNumber;

    // Constructor using super keyword
    ShippedOrder(int orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    // Overridden method
    @Override
    String getOrderStatus() {
        return "Order Shipped (Tracking No: " + trackingNumber + ")";
    }
}

/*
 * DeliveredOrder class
 *
 * Extends ShippedOrder and adds delivery details.
 */
class DeliveredOrder extends ShippedOrder {

    String deliveryDate;

    // Constructor using super keyword
    DeliveredOrder(int orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    // Overridden method
    @Override
    String getOrderStatus() {
        return "Order Delivered on " + deliveryDate;
    }
}

public class OnlineRetailOrderManagement {

    public static void main(String[] args) {

        Order order1 = new Order(1001, "01-10-2025");
        Order order2 = new ShippedOrder(1002, "02-10-2025", "TRK12345");
        Order order3 = new DeliveredOrder(1003, "03-10-2025", "TRK67890", "06-10-2025");

        // Polymorphism: method call depends on actual object type
        System.out.println(order1.getOrderStatus());
        System.out.println(order2.getOrderStatus());
        System.out.println(order3.getOrderStatus());
    }
}
