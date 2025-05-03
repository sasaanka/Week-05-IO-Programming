import java.io.*;
import java.util.*;
public class DetectDuplicates {
    public static void main(String[] args) {
        String filePath = "student2.csv";  
        Set<String> uniqueIds = new HashSet<>();
        List<String> duplicateRecords = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false; 
                    continue;
                }
                String[] columns = line.split(",");
                if (columns.length >= 1) {
                    String id = columns[0].trim();
                    if (uniqueIds.contains(id)) {
                        duplicateRecords.add(line); 
                    } else {
                        uniqueIds.add(id); 
                    }
                }
            }
            if (!duplicateRecords.isEmpty()) {
                System.out.println("Found duplicate records based on ID:");
                for (String record : duplicateRecords) {
                    System.out.println(record);
                }
            } else {
                System.out.println("No duplicates found.");
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}