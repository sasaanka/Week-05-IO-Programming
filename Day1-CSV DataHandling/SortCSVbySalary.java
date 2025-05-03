import java.io.*;
import java.util.*;
public class SortCSVbySalary{
    public static void main(String[] args) {
        String filepath="EmployeeDetails.csv";
        List<String[]> employees=new ArrayList<>();
        try(BufferedReader br=new BufferedReader(new FileReader(filepath))){
            String line;
            boolean isHeader=   true;
            String[] header=null;
            while((line=br.readLine())!=null){
                String[] columns=line.split(",");
                if(isHeader){
                    header=columns;
                    isHeader=false;
                    continue;
                }
                if(columns.length>=4){
                    employees.add(columns);
                }
            }
            employees.sort((e1, e2) -> {
                double salary1 = Double.parseDouble(e1[3].trim());
                double salary2 = Double.parseDouble(e2[3].trim());
                return Double.compare(salary2, salary1); 
            });
            System.out.println("Top 5 Highest Paid Employees:");
            System.out.println(String.join(" | ", header));
            for (int i = 0; i < Math.min(5, employees.size()); i++) {
            System.out.println(String.join(" | ", employees.get(i)));
            }
        }catch (IOException e){
            
        }
    }
}