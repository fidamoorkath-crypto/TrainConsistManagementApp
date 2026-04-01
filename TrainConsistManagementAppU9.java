import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TrainConsistManagementAppU9 {
    public static void main(String[] args) {
        List<Bogie> passengerBogies = new ArrayList<>();

        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 56));
        passengerBogies.add(new Bogie("First Class", 48));
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 60));

        System.out.println("Train Consist Management App - UC9: Group Bogies by Type\n");

        Map<String, List<Bogie>> groupedBogies = groupBogiesByType(passengerBogies);

        System.out.println("Grouped bogies by type:");
        displayGroupedBogies(groupedBogies);

        System.out.println("\nOriginal passenger bogie list remains unchanged after grouping:");
        displayBogies(passengerBogies);
    }

    private static Map<String, List<Bogie>> groupBogiesByType(List<Bogie> bogies) {
        return bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getName));
    }

    private static void displayGroupedBogies(Map<String, List<Bogie>> groupedBogies) {
        groupedBogies.forEach((type, bogies) -> {
            System.out.println(type + ":");
            bogies.forEach(bogie -> System.out.println("  - " + bogie.getName() + " (" + bogie.getCapacity() + " seats)"));
        });
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
