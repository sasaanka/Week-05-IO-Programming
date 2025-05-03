import java.io.*;
import java.util.Scanner;
public class SearchforRecord{
    public static void main(String[] args) {
        String filepath="EmployeeDetails.csv";
        Scanner inp=new Scanner(System.in);
        System.out.print("Enter the employee name: ");
        String searchName=inp.nextLine().trim().toLowerCase();
        boolean found=false;
        
        try(BufferedReader br=new BufferedReader(new FileReader(filepath))){
            String line;
            while((line=br.readLine())!=null){
                String[] columns=line.split(",");
                if(columns.length>=4){
                    String name=columns[1].trim().toLowerCase();
                    if(name.equals(searchName)){
                        String dep=columns[2].trim();
                        String salary=columns[3].trim();
                        System.out.println("Employee found");
                        System.out.println("Department: "+dep);
                        System.out.println("Salary: "+salary);
                        found=true;
                        break;
                    }
                }
            }
            if(!found){
                    System.out.println("Employee not found");
                }
        }catch(IOException e){

        }
    }
}