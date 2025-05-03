import java.io.*;
import java.util.*;
public class MergeTwoCSVFiles {
    public static void main(String[] args) {
        String file1 = "Student1.csv"; 
        String file2 = "Student2.csv";
        String outputFile = "MergedStudents.csv";
        Map<String, String[]> studentInfo = new HashMap<>();
        Map<String, String[]> studentMarks = new HashMap<>();
        try (BufferedReader br1 = new BufferedReader(new FileReader(file1))) {
            br1.readLine(); 
            String line;
            while ((line = br1.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    studentInfo.put(parts[0].trim(), new String[]{parts[1].trim(), parts[2].trim()});
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file1: " + e.getMessage());
        }
        try (BufferedReader br2 = new BufferedReader(new FileReader(file2))) {
            br2.readLine(); 
            String line;
            while ((line = br2.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    studentMarks.put(parts[0].trim(), new String[]{parts[1].trim(), parts[2].trim()});
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file2: " + e.getMessage());
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write("ID,Name,Age,Marks,Grade");
            writer.newLine();
            for (String id : studentInfo.keySet()) {
                if (studentMarks.containsKey(id)) {
                    String[] info = studentInfo.get(id);
                    String[] marks = studentMarks.get(id);
                    writer.write(id + "," + info[0] + "," + info[1] + "," + marks[0] + "," + marks[1]);
                    writer.newLine();
                }
            }

            System.out.println("Merged file created successfully: " + outputFile);
        } catch (IOException e) {
            System.out.println("Error writing merged file: " + e.getMessage());
        }
    }
}
