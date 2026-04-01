import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementAppU14 {
    public static void main(String[] args) {
        List<PassengerBogie> bogies = new ArrayList<>();

        try {
            bogies.add(new PassengerBogie("Sleeper", 72));
            bogies.add(new PassengerBogie("AC Chair", 56));
            bogies.add(new PassengerBogie("First Class", 48));
            // This line demonstrates invalid capacity handling.
            bogies.add(new PassengerBogie("Economy", 0));
        } catch (InvalidCapacityException e) {
            System.out.println("Invalid bogie creation: " + e.getMessage());
        }

        System.out.println("Train Consist Management App - UC14: Handle Invalid Bogie Capacity (Custom Exception)\n");
        System.out.println("Valid passenger bogies in the train consist:");
        displayPassengerBogies(bogies);
        System.out.println("\nProgram continues safely after validation.");
    }

    private static void displayPassengerBogies(List<PassengerBogie> bogies) {
        System.out.printf("%-15s %s%n", "Bogie Type", "Capacity");
        System.out.println("-----------------------------");
        for (PassengerBogie bogie : bogies) {
            System.out.printf("%-15s %d%n", bogie.getType(), bogie.getCapacity());
        }
    }

    static class PassengerBogie {
        private final String type;
        private final int capacity;

        public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
            validateCapacity(capacity);
            this.type = type;
            this.capacity = capacity;
        }

        private void validateCapacity(int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
        }

        public String getType() {
            return type;
        }

        public int getCapacity() {
            return capacity;
        }
    }

    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }
}
