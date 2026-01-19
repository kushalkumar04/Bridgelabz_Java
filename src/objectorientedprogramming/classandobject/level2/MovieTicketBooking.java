package objectorientedprogramming.classandobject.level2;

/*
 * This class represents a Movie Ticket in a simple booking system.
 * It stores details such as movie name, seat number, and ticket price.
 * It provides methods to book a ticket and display the ticket information.
 */
class MovieTicket {

    // Instance variables to store ticket details
    String movieName;
    int seatNumber;
    double price;

    // Method to book a ticket by assigning seat number and price
    public void bookTicket(String name, int seat, double ticketPrice) {
        movieName = name;
        seatNumber = seat;
        price = ticketPrice;
    }

    // Method to display ticket details
    public void displayTicketDetails() {
        System.out.println("Movie Name : " + movieName);
        System.out.println("Seat No.   : " + seatNumber);
        System.out.println("Price      : INR " + price);
    }
}

/*
 * This class contains the main method to simulate
 * a simple movie ticket booking process.
 */
public class MovieTicketBooking {

    public static void main(String[] args) {

        // Create an object of MovieTicket class
        MovieTicket ticket = new MovieTicket();

        // Book a ticket by providing movie name, seat number, and price
        ticket.bookTicket("Inception", 15, 250.0);

        // Display the booked ticket details
        ticket.displayTicketDetails();
    }
}
