import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TrainConsistManagementAppU7 {
    public static void main(String[] args) {
        List<Bogie> passengerBogies = new ArrayList<>();

        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 56));
        passengerBogies.add(new Bogie("First Class", 48));
        passengerBogies.add(new Bogie("Economy", 64));

        System.out.println("Train Consist Management App - UC7: Sort Bogies by Capacity\n");
        System.out.println("Passenger bogies before sorting:");
        displayBogies(passengerBogies);

        passengerBogies.sort(Comparator.comparingInt(Bogie::getCapacity).reversed());

        System.out.println("\nPassenger bogies after sorting by seating capacity (high to low):");
        displayBogies(passengerBogies);
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
