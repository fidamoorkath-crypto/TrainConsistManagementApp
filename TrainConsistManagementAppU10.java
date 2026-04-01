import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementAppU10 {
    public static void main(String[] args) {
        List<Bogie> passengerBogies = new ArrayList<>();

        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 56));
        passengerBogies.add(new Bogie("First Class", 48));
        passengerBogies.add(new Bogie("Economy", 64));

        System.out.println("Train Consist Management App - UC10: Count Total Seats in Train\n");

        int totalSeats = calculateTotalSeats(passengerBogies);
        System.out.println("Total seating capacity in the train: " + totalSeats);

        System.out.println("\nOriginal passenger bogie list remains unchanged after aggregation:");
        displayBogies(passengerBogies);
    }

    private static int calculateTotalSeats(List<Bogie> bogies) {
        return bogies.stream()
                .map(b -> b.getCapacity())
                .reduce(0, Integer::sum);
    }

    private static void displayBogies(List<Bogie> bogies) {
        System.out.printf("%-15s %s%n", "Bogie Name", "Capacity");
        System.out.println("-----------------------------");
        for (Bogie bogie : bogies) {
            System.out.printf("%-15s %d%n", bogie.getName(), bogie.getCapacity());
        }
    }

    static class Bogie {
        private final String name;
        private final int capacity;

        public Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        public String getName() {
            return name;
        }

        public int getCapacity() {
            return capacity;
        }

        @Override
        public String toString() {
            return name + " (" + capacity + " seats)";
        }
    }
}
