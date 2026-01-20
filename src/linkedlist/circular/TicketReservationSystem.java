package linkedlist.circular;

/***************************************************************
 * Online Ticket Reservation System using Circular Linked List
 *
 * Each node represents a booked ticket with:
 *  - Ticket ID
 *  - Customer Name
 *  - Movie Name
 *  - Seat Number
 *  - Booking Time
 *
 * Features:
 * 1. Add ticket at end
 * 2. Remove ticket by ID
 * 3. Display all tickets
 * 4. Search by Customer Name or Movie Name
 * 5. Count total booked tickets
 ***************************************************************/

// Node representing a Ticket
class TicketNode {

    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    TicketNode next;

    // Constructor
    public TicketNode(int id, String customer, String movie, String seat, String time) {
        this.ticketId = id;
        this.customerName = customer;
        this.movieName = movie;
        this.seatNumber = seat;
        this.bookingTime = time;
        this.next = null;
    }
}

/*
 * Circular Linked List for Ticket Reservation
 */
class TicketCircularList {

    TicketNode head = null;
    TicketNode tail = null;

    // Add ticket at end
    public void addTicket(int id, String customer, String movie, String seat, String time) {
        TicketNode newNode = new TicketNode(id, customer, movie, seat, time);

        if (head == null) {
            head = tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
    }

    // Remove ticket by Ticket ID
    public void removeTicket(int id) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        TicketNode current = head;
        TicketNode prev = null;

        do {
            if (current.ticketId == id) {
                // If deleting head node
                if (current == head) {
                    // Single node case
                    if (head == tail) {
                        head = tail = null;
                    } else {
                        // Find last node to update its next pointer
                        TicketNode last = head;
                        while (last.next != head) {
                            last = last.next;
                        }
                        head = head.next;
                        last.next = head;
                        tail = last;
                    }
                }
                // If deleting non-head node
                else {
                    prev.next = current.next;
                    if (current == tail) {
                        tail = prev;
                    }
                }
                System.out.println("Ticket removed successfully.");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        System.out.println("Ticket not found.");
    }

    // Display all tickets
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        TicketNode temp = head;
        do {
            displayTicket(temp);
            temp = temp.next;
        } while (temp != head);
    }

    // Search by Customer Name
    public void searchByCustomer(String customer) {
        if (head == null) return;

        TicketNode temp = head;
        boolean found = false;

        do {
            if (temp.customerName.equalsIgnoreCase(customer)) {
                displayTicket(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No ticket found for customer: " + customer);
        }
    }

    // Search by Movie Name
    public void searchByMovie(String movie) {
        if (head == null) return;

        TicketNode temp = head;
        boolean found = false;

        do {
            if (temp.movieName.equalsIgnoreCase(movie)) {
                displayTicket(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No ticket found for movie: " + movie);
        }
    }

    // Count total tickets
    public int countTickets() {
        if (head == null) return 0;

        int count = 0;
        TicketNode temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        return count;
    }

    // Helper method to display one ticket
    private void displayTicket(TicketNode t) {
        System.out.println("-----------------------------");
        System.out.println("Ticket ID    : " + t.ticketId);
        System.out.println("Customer     : " + t.customerName);
        System.out.println("Movie        : " + t.movieName);
        System.out.println("Seat Number  : " + t.seatNumber);
        System.out.println("Booking Time : " + t.bookingTime);
    }
}

/*
 * Main class to test Online Ticket Reservation System
 */
public class TicketReservationSystem {

    public static void main(String[] args) {

        TicketCircularList system = new TicketCircularList();

        // Add ticket bookings
        system.addTicket(1, "Kushal", "Inception", "A10", "10:30 AM");
        system.addTicket(2, "Amit", "Avatar", "B12", "11:00 AM");
        system.addTicket(3, "Neha", "Inception", "C05", "11:15 AM");

        // Display all tickets
        System.out.println("All Booked Tickets:");
        system.displayTickets();

        // Search by customer
        system.searchByCustomer("Kushal");

        // Search by movie
        system.searchByMovie("Inception");

        // Remove a ticket
        system.removeTicket(2);

        // Display after removal
        System.out.println("\nAfter Removal:");
        system.displayTickets();

        // Count total tickets
        System.out.println("\nTotal Tickets Booked: " + system.countTickets());
    }
}
