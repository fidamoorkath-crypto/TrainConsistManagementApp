import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TrainConsistManagementAppU11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Train Consist Management App - UC11: Validate Train ID & Cargo Codes (Regex)\n");

        System.out.print("Enter Train ID (format TRN-1234): ");
        String trainId = scanner.nextLine().trim();

        System.out.print("Enter Cargo Code (format PET-AB): ");
        String cargoCode = scanner.nextLine().trim();

        boolean trainIdValid = validateTrainId(trainId);
        boolean cargoCodeValid = validateCargoCode(cargoCode);

        System.out.println();
        System.out.println("Train ID: " + trainId + " -> " + (trainIdValid ? "VALID" : "INVALID"));
        System.out.println("Cargo Code: " + cargoCode + " -> " + (cargoCodeValid ? "VALID" : "INVALID"));

        if (!trainIdValid) {
            System.out.println("Error: Train ID must match the format TRN-1234.");
        }

        if (!cargoCodeValid) {
            System.out.println("Error: Cargo Code must match the format PET-AB.");
        }

        System.out.println();
        System.out.println("Validation completed. Program continues.");

        scanner.close();
    }

    private static boolean validateTrainId(String trainId) {
        Pattern pattern = Pattern.compile("TRN-\\d{4}");
        Matcher matcher = pattern.matcher(trainId);
        return matcher.matches();
    }

    private static boolean validateCargoCode(String cargoCode) {
        Pattern pattern = Pattern.compile("PET-[A-Z]{2}");
        Matcher matcher = pattern.matcher(cargoCode);
        return matcher.matches();
    }
}
