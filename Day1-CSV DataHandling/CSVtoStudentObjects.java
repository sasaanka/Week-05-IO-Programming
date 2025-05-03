import java.io.*;
import java.util.*;
class Student {
    final private String id;
    final private String name;
    final private int age;
    final private double marks;
    public Student(String id, String name, int age, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Marks: " + marks;
    }
}
public class CSVtoStudentObjects {
    public static void main(String[] args) {
        String filePath = "StudentDetails.csv";
        List<Student> students = new ArrayList<>();
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
                    String name = columns[1].trim();
                    int age = Integer.parseInt(columns[2].trim());
                    double marks = Double.parseDouble(columns[3].trim());
                    Student student = new Student(id, name, age, marks);
                    students.add(student);
                }
            }
            for (Student s : students) {
                System.out.println(s);
            }
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Data parsing error: " + e.getMessage());
        }
    }
}
