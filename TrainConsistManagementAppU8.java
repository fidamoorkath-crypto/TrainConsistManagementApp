import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrainConsistManagementAppU8 {
    public static void main(String[] args) {
        List<Bogie> passengerBogies = new ArrayList<>();

        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 56));
        passengerBogies.add(new Bogie("First Class", 48));
        passengerBogies.add(new Bogie("Economy", 64));

        System.out.println("Train Consist Management App - UC8: Filter Passenger Bogies Using Streams\n");
        List<Bogie> filteredBogies = filterBogiesByCapacity(passengerBogies, 60);

        System.out.println("Passenger bogies with capacity greater than 60:");
        displayBogies(filteredBogies);

        System.out.println("\nOriginal passenger bogie list remains unchanged after filtering:");
        displayBogies(passengerBogies);
    }

    private static List<Bogie> filterBogiesByCapacity(List<Bogie> bogies, int capacityThreshold) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > capacityThreshold)
                .collect(Collectors.toList());
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
