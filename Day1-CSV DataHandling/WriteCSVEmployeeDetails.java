import java.io.*;
public class WriteCSVEmployeeDetails {
    public static void main(String[] args) {
        String filePath = "EmployeeDetails.csv";
        String[][] employees = {
            {"101", "Sasanka", "Engineering", "150000"},
            {"102", "Bharath", "Marketing", "62000"},
            {"103", "Abhinaya", "HR", "54000"},
            {"104", "Shasank", "Engineering", "80000"},
            {"105", "Hemateja", "Finance", "90000"}
        };
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("ID,Name,Department,Salary"); //Header to the CSV file using write
            writer.newLine(); 
            for (String[] employee : employees) {
                writer.write(String.join(",", employee));
                writer.newLine(); 
            }
            System.out.println("Data written to CSV file successfully.");
        } catch (IOException e) {
            
        }
    }
}
