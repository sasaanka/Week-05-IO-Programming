import java.io.*;
public class UpdateValueinCSV{
    public static void main(String[] args) {
        String inputfile="EmployeeDetails.csv";
        String outputfile="UpdatedEmployeeDetails.csv";
        try(BufferedReader br=new BufferedReader(new FileReader(inputfile));
            BufferedWriter bw=new BufferedWriter(new FileWriter(outputfile)); 
        ){
            String line;
            boolean isHeader=true;
            while((line=br.readLine())!=null){
                String[] columns=line.split(",");
                if(isHeader){
                    bw.write(line);
                    bw.newLine();
                    isHeader=false;
                    continue;
                }
                if(columns.length>=4){
                    String dep=columns[2].trim();
                    double salary=Double.parseDouble(columns[3].trim());
                    if(dep.equalsIgnoreCase("Engineering")){
                        salary*=1.10;
                        columns[3]=String.format("%5f",salary);
                    }
                    bw.write(String.join(",",columns));
                    bw.newLine();
                }
            }
            System.out.println("Updated salaries in "+outputfile);
        }catch(IOException e){

        }
    }
}