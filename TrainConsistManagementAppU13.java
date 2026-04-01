import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrainConsistManagementAppU13 {
    public static void main(String[] args) {
        List<Bogie> bogies = createTestBogies(10000);

        System.out.println("Train Consist Management App - UC13: Performance Comparison (Loops vs Streams)\n");

        long loopStart = System.nanoTime();
        List<Bogie> loopFiltered = filterWithLoop(bogies, 60);
        long loopEnd = System.nanoTime();
        long loopDuration = loopEnd - loopStart;

        long streamStart = System.nanoTime();
        List<Bogie> streamFiltered = filterWithStream(bogies, 60);
        long streamEnd = System.nanoTime();
        long streamDuration = streamEnd - streamStart;

        System.out.println("Loop filtered count: " + loopFiltered.size());
        System.out.println("Stream filtered count: " + streamFiltered.size());
        System.out.println("Loop duration (ns): " + loopDuration);
        System.out.println("Stream duration (ns): " + streamDuration);

        System.out.println("\nResults match: " + loopFiltered.equals(streamFiltered));
        System.out.println("Program continues.");
    }

    private static List<Bogie> createTestBogies(int count) {
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            int capacity = 40 + (i % 70);
            bogies.add(new Bogie("Bogie-" + i, capacity));
        }
        return bogies;
    }

    private static List<Bogie> filterWithLoop(List<Bogie> bogies, int threshold) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie bogie : bogies) {
            if (bogie.getCapacity() > threshold) {
                result.add(bogie);
            }
        }
        return result;
    }

    private static List<Bogie> filterWithStream(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(bogie -> bogie.getCapacity() > threshold)
                .collect(Collectors.toList());
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
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Bogie bogie = (Bogie) obj;
            return capacity == bogie.capacity && name.equals(bogie.name);
        }

        @Override
        public int hashCode() {
            int result = name.hashCode();
            result = 31 * result + capacity;
            return result;
        }
    }
}
