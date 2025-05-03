import java.io.*;
public class FilteringRecords{
    public static void main(String[] args) {
        String filepath="StudentDetails.csv";
        try(BufferedReader br=new BufferedReader(new FileReader(filepath))){
            String line;
            String header=br.readLine();
            System.out.println("Qualifying Marks is >90 ");
            System.out.println(header);
            while((line=br.readLine())!=null){
                String[] columns=line.split(",");
                int marks=Integer.parseInt(columns[3].trim());
                if(marks>90){
                    System.out.println(line);
                }
            }
        }catch(IOException | NumberFormatException e){

        }
    }
}