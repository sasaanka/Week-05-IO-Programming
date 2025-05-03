import java.io.*;
import java.util.regex.*;
public class ValidateCSV {
    public static void main(String[] args) {
        String filePath = "UserDetails.csv";
        Pattern emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue; 
                }
                String[] columns = line.split(",");
                if (columns.length >= 4) {
                    String id = columns[0].trim();
                    @SuppressWarnings("unused")
                    String name = columns[1].trim();
                    String email = columns[2].trim();
                    String phone = columns[3].trim();
                    boolean valid = true;
                    if (!emailPattern.matcher(email).matches()) {
                        System.out.println("Invalid Email in row: " + line);
                        valid = false;
                    }
                    if (!phone.matches("\\d{10}")) {
                        System.out.println("Invalid Phone Number in row: " + line);
                        valid = false;
                    }
                    if (!valid) {
                        System.out.println("→ Validation failed for record ID: " + id);
                    }
                } else {
                    System.out.println("Invalid line format: " + line);
                }
            }

        } catch (IOException e) {
            System.out.println("File read error: " + e.getMessage());
        }
    }
}
