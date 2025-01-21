package src;
/**
Simulate a movie theater that helps users to book and reserve seats.
1. reserve seats (if seat is taken, let them know it is taken and suggest an available seat)
2. cancel seats
3. retrieve initial seating charting
 */

 public class MovieTheatre {
    private static String[][] seats;

    public static void main(String[] args) {
        // Set up predefined rows and columns. Can change them to whatever really.
        int rows = 5;
        int columns = 5;

        // seating chart. Initializes the 5 and 5 i set above
        seats = new String[rows][columns];

        // TESTING CODE (what will be displayed when you run)

        System.out.println();
        System.out.println("Initial Seating Chart: ");
        viewSeats(rows, columns);  // Display the initial chart

        // seat reservations
        System.out.println();
        System.out.println("Reserved Seats: ");
        reserveSeats(1, 1);  // row 1, column 1 and so on
        reserveSeats(2, 2);  // these have to be within 5 and 5, UNLESS you change the length of the rows and columms above.
        reserveSeats(3, 3);  

        // updated seating chart after reservations
        System.out.println();
        System.out.println("\nUpdated Seating Chart after reservations: ");
        viewSeats(rows, columns);

        // seat cancellations
        System.out.println("\nSeat Cancellations: ");
        System.out.println();
        cancelSeats(1, 1);  // Cancels the reservation at row 1, column 1. Again, can change this if you want.

        // updated seating chart again. this time after cancellations
        System.out.println();
        System.out.println("\nUpdated Seating Chart after cancellation: ");
        viewSeats(rows, columns);

        // Suggest an available seat
        System.out.println();
        System.out.println("\nSuggested Seat: ");
        suggestSeat(rows, columns);
    }

    // METHODS THAT MAKE ABOVE CODD WORK PROPERLY

    // reserve a seat
    public static void reserveSeats(int row, int column) {
        if (seats[row][column] == null) {
            seats[row][column] = "Reserved"; // tries to reserve seat, marks as reserved if null (available).
            System.out.println("Seat reserved at row " + (row + 1) + ", column " + (column + 1));
        } else {
            System.out.println("This seat is taken at row " + (row + 1) + ", column " + (column + 1)); // otherwise, says its taken
            suggestSeat(seats.length, seats[0].length);  // and suggests another seat
        }
    }

    // cancel a seat reservation
    public static void cancelSeats(int row, int column) {
        if (seats[row][column] != null) {
            seats[row][column] = null; // if a seats reserved (not available) and u want to cancel, it will do it based on user input/tests above.
            System.out.println("Seat at row " + (row + 1) + ", column " + (column + 1) + " has been canceled.");
        } else {
            System.out.println("This seat is not reserved at row " + (row + 1) + ", column " + (column + 1));
        }
    }

    // view the current seating chart
    public static void viewSeats(int rows, int columns) { // i represents current row, c represents current column
        for (int i = 0; i < rows; i++) {
            for (int c = 0; c < columns; c++) {
                System.out.print((seats[i][c] == null ? "Available" : "Reserved") + "\t"); // iterates through chart and mark either available or reserved based on user input/tests above.
            }
            System.out.println();
        }
    }

    // suggest an available seat
    public static void suggestSeat(int rows, int columns) {
        for (int i = 0; i < rows; i++) {
            for (int c = 0; c < columns; c++) {
                if (seats[i][c] == null) {
                    System.out.println("Suggested seat is row " + (i + 1) + ", column " + (c + 1)); // same thing as above however will suggest the first available seat.
                    return;
                }
            }
        }
        System.out.println("Sorry, no available seats left."); // only shows if theres no seats left at all.
    }
}

    


