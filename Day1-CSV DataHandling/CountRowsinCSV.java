import java.io.*;
public class CountRowsinCSV{
    public static void main(String[] args) {
        String filepath="StudentDetails.csv";
        int rowcount=0;
        try(BufferedReader br=new BufferedReader(new FileReader(filepath))){
            @SuppressWarnings("unused")
            String line;
            String header=br.readLine();
            System.out.println("Header: "+header);
            while((line=br.readLine())!=null){
                rowcount++;
                //String[] columns=line.split(",");
                //System.out.println("Row: "+rowcount+ String.join(" | ", columns));
            }
            System.out.println("Total number of data rows: "+rowcount);
        }catch(IOException e){

        }
    }
}