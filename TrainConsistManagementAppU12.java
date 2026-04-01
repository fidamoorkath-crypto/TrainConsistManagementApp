import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementAppU12 {
    public static void main(String[] args) {
        List<GoodsBogie> goodsBogies = new ArrayList<>();

        goodsBogies.add(new GoodsBogie("Rectangular", "Coal"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Rectangular", "Grain"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));

        System.out.println("Train Consist Management App - UC12: Safety Compliance Check for Goods Bogies\n");

        boolean safeTrain = isTrainSafetyCompliant(goodsBogies);

        System.out.println("Goods bogie safety compliance result: " + (safeTrain ? "SAFE" : "UNSAFE"));
        System.out.println();
        System.out.println("Goods bogies processed:");
        displayGoodsBogies(goodsBogies);
    }

    private static boolean isTrainSafetyCompliant(List<GoodsBogie> bogies) {
        return bogies.stream()
                .allMatch(bogie -> !bogie.getType().equalsIgnoreCase("Cylindrical")
                        || bogie.getCargo().equalsIgnoreCase("Petroleum"));
    }

    private static void displayGoodsBogies(List<GoodsBogie> bogies) {
        System.out.printf("%-15s %-15s%n", "Bogie Type", "Cargo");
        System.out.println("-------------------------------");
        for (GoodsBogie bogie : bogies) {
            System.out.printf("%-15s %-15s%n", bogie.getType(), bogie.getCargo());
        }
    }

    static class GoodsBogie {
        private final String type;
        private final String cargo;

        public GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }

        public String getType() {
            return type;
        }

        public String getCargo() {
            return cargo;
        }

        @Override
        public String toString() {
            return type + " bogie carrying " + cargo;
        }
    }
}
