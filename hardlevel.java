class TicketBookingSystem {
    private int availableSeats;

    public TicketBookingSystem(int seats) {
        this.availableSeats = seats;
    }

    public synchronized void bookTicket(String customerType) {
        if (availableSeats > 0) {
            System.out.println(customerType + " is booking a seat...");
            try {

                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            availableSeats--;
            System.out.println(customerType + " booked a seat. Remaining seats: " + availableSeats);
        } else {
            System.out.println(customerType + ": Sorry, no seats available.");
        }
    }
}

class BookingThread extends Thread {
    private TicketBookingSystem system;
    private String customerType;

    public BookingThread(TicketBookingSystem system, String customerType) {
        this.system = system;
        this.customerType = customerType;
    }

    @Override
    public void run() {
        system.bookTicket(customerType);
    }
}

public class TicketBooking {
    public static void main(String[] args) {

        TicketBookingSystem system = new TicketBookingSystem(5);

        Thread vip1 = new BookingThread(system, "VIP Customer 1");
        Thread vip2 = new BookingThread(system, "VIP Customer 2");
        Thread normal1 = new BookingThread(system, "Normal Customer 1");
        Thread normal2 = new BookingThread(system, "Normal Customer 2");
        Thread normal3 = new BookingThread(system, "Normal Customer 3");
        Thread normal4 = new BookingThread(system, "Normal Customer 4");

        vip1.setPriority(Thread.MAX_PRIORITY);
        vip2.setPriority(Thread.MAX_PRIORITY); 

        normal1.setPriority(Thread.NORM_PRIORITY); 
        normal2.setPriority(Thread.NORM_PRIORITY);
        normal3.setPriority(Thread.NORM_PRIORITY); 
        normal4.setPriority(Thread.NORM_PRIORITY); 

        vip1.start();
        vip2.start();
        normal1.start();
        normal2.start();
        normal3.start();
        normal4.start();

        try {
            vip1.join();
            vip2.join();
            normal1.join();
            normal2.join();
            normal3.join();
            normal4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Booking process finished.");
    }
}
