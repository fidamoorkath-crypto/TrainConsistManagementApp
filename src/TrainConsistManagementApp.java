import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TrainConsistManagementApp {

    static class PassengerBogie {
        private final String type;
        private final int capacity;

        PassengerBogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }

        String getType() {
            return type;
        }

        int getCapacity() {
            return capacity;
        }

        @Override
        public String toString() {
            return type + " -> " + capacity + " seats";
        }
    }

    static class GoodsBogie {
        private final String shape;
        private final String cargo;

        GoodsBogie(String shape, String cargo) {
            this.shape = shape;
            this.cargo = cargo;
        }

        String getShape() {
            return shape;
        }

        String getCargo() {
            return cargo;
        }

        @Override
        public String toString() {
            return shape + " -> " + cargo;
        }
    }

    static class InvalidCapacityException extends Exception {
        InvalidCapacityException(String message) {
            super(message);
        }
    }

    static class ValidatedPassengerBogie {
        private final String type;
        private final int capacity;

        ValidatedPassengerBogie(String type, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.type = type;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return type + " -> " + capacity + " seats";
        }
    }

    private static final Pattern TRAIN_ID_PATTERN = Pattern.compile("TRN-\\d{4}");
    private static final Pattern CARGO_CODE_PATTERN = Pattern.compile("PET-[A-Z]{2}");

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        List<PassengerBogie> passengerBogies = new ArrayList<>();
        passengerBogies.add(new PassengerBogie("Sleeper", 72));
        passengerBogies.add(new PassengerBogie("AC Chair", 56));
        passengerBogies.add(new PassengerBogie("First Class", 24));
        passengerBogies.add(new PassengerBogie("Double Decker", 120));

        runUC1(passengerBogies);
        runUC2(passengerBogies);
        runUC3();
        runUC4(passengerBogies);
        runUC5(passengerBogies);
        runUC6(passengerBogies);
        runUC7(passengerBogies);
        runUC8(passengerBogies);
        runUC9(passengerBogies);
        runUC10(passengerBogies);
        runUC11("TRN-1234", "PET-AB");
        runUC12();
        runUC13(passengerBogies);
        runUC14();
    }

    private static void runUC1(List<PassengerBogie> bogies) {
        System.out.println("\nUC1: Initialize Train and Display Summary");
        System.out.println("Total bogies: " + bogies.size());
    }

    private static void runUC2(List<PassengerBogie> bogies) {
        System.out.println("\nUC2: Add Passenger Bogies");
        List<PassengerBogie> local = new ArrayList<>(bogies);
        local.add(new PassengerBogie("Economy", 80));
        System.out.println("After add, total bogies: " + local.size());
    }

    private static void runUC3() {
        System.out.println("\nUC3: Enforce Unique Bogie IDs (HashSet)");
        Set<String> bogieIds = new HashSet<>();
        bogieIds.add("BG-101");
        bogieIds.add("BG-102");
        bogieIds.add("BG-101");
        System.out.println("Unique bogie IDs count: " + bogieIds.size());
    }

    private static void runUC4(List<PassengerBogie> bogies) {
        System.out.println("\nUC4: Ordered Train Consist (LinkedList)");
        LinkedList<PassengerBogie> linked = new LinkedList<>(bogies);
        System.out.println("First bogie: " + linked.getFirst());
        System.out.println("Last bogie: " + linked.getLast());
    }

    private static void runUC5(List<PassengerBogie> bogies) {
        System.out.println("\nUC5: Ordered Unique Bogies (LinkedHashSet)");
        LinkedHashSet<String> set = new LinkedHashSet<>();
        for (PassengerBogie bogie : bogies) {
            set.add(bogie.getType());
        }
        set.add("Sleeper");
        System.out.println("Ordered unique bogie types: " + set);
    }

    private static void runUC6(List<PassengerBogie> bogies) {
        System.out.println("\nUC6: Map Bogie Type to Capacity (HashMap)");
        Map<String, Integer> map = new HashMap<>();
        for (PassengerBogie bogie : bogies) {
            map.put(bogie.getType(), bogie.getCapacity());
        }
        System.out.println("Capacity map: " + map);
    }

    private static void runUC7(List<PassengerBogie> bogies) {
        System.out.println("\nUC7: Sort Bogies by Capacity");
        List<PassengerBogie> sorted = new ArrayList<>(bogies);
        sorted.sort(Comparator.comparingInt(PassengerBogie::getCapacity));
        sorted.forEach(System.out::println);
    }

    private static void runUC8(List<PassengerBogie> bogies) {
        System.out.println("\nUC8: Filter Passenger Bogies using Stream");
        List<PassengerBogie> filtered = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
        filtered.forEach(System.out::println);
    }

    private static void runUC9(List<PassengerBogie> bogies) {
        System.out.println("\nUC9: Group Bogies by Type");
        Map<String, List<PassengerBogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(PassengerBogie::getType));
        grouped.forEach((k, v) -> System.out.println(k + " => " + v));
    }

    private static void runUC10(List<PassengerBogie> bogies) {
        System.out.println("\nUC10: Count Total Seats using reduce");
        int totalSeats = bogies.stream().map(PassengerBogie::getCapacity).reduce(0, Integer::sum);
        System.out.println("Total seating capacity: " + totalSeats);
    }

    private static void runUC11(String trainId, String cargoCode) {
        System.out.println("\nUC11: Validate Train ID and Cargo Codes using Regex");
        boolean trainValid = TRAIN_ID_PATTERN.matcher(trainId).matches();
        boolean cargoValid = CARGO_CODE_PATTERN.matcher(cargoCode).matches();
        System.out.println("Train ID " + trainId + " valid: " + trainValid);
        System.out.println("Cargo code " + cargoCode + " valid: " + cargoValid);
    }

    private static void runUC12() {
        System.out.println("\nUC12: Goods Bogie Safety Compliance");
        List<GoodsBogie> goods = new ArrayList<>();
        goods.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goods.add(new GoodsBogie("Open", "Coal"));
        boolean safe = goods.stream().allMatch(b -> !"Cylindrical".equalsIgnoreCase(b.getShape())
                || "Petroleum".equalsIgnoreCase(b.getCargo()));
        System.out.println("Safety compliant: " + safe);
    }

    private static void runUC13(List<PassengerBogie> bogies) {
        System.out.println("\nUC13: Loop vs Stream Performance");
        long loopStart = System.nanoTime();
        List<PassengerBogie> loopResult = new ArrayList<>();
        for (PassengerBogie bogie : bogies) {
            if (bogie.getCapacity() > 60) {
                loopResult.add(bogie);
            }
        }
        long loopEnd = System.nanoTime();

        long streamStart = System.nanoTime();
        List<PassengerBogie> streamResult = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
        long streamEnd = System.nanoTime();

        System.out.println("Loop result size: " + loopResult.size() + ", time(ns): " + (loopEnd - loopStart));
        System.out.println("Stream result size: " + streamResult.size() + ", time(ns): " + (streamEnd - streamStart));
    }

    private static void runUC14() {
        System.out.println("\nUC14: Custom Exception for Invalid Capacity");
        try {
            ValidatedPassengerBogie valid = new ValidatedPassengerBogie("Sleeper", 72);
            System.out.println("Created: " + valid);
            new ValidatedPassengerBogie("AC Chair", 0);
        } catch (InvalidCapacityException e) {
            System.out.println("Validation failed: " + e.getMessage());
        }
    }
}
