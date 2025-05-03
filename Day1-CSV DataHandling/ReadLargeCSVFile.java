import java.io.*;
public class ReadLargeCSVFile {
    public static void main(String[] args) {
        String filePath = "LargeStudentData.csv"; 
        final int CHUNK_SIZE = 100;
        int totalCount = 0;
        int chunkCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            @SuppressWarnings("unused")
            String line;
            boolean isHeader = true;
            while (true) {
                int linesRead = 0;
                while (linesRead < CHUNK_SIZE && (line = br.readLine()) != null) {
                    if (isHeader) {
                        isHeader = false; 
                        continue;
                    }
                    linesRead++;
                    totalCount++;
                }

                if (linesRead > 0) {
                    chunkCount++;
                    System.out.println("Processed chunk " + chunkCount + ": " + linesRead + " lines");
                }
                if (linesRead < CHUNK_SIZE) {
                    break;
                }
            }

            System.out.println("Total records processed (excluding header): " + totalCount);

        } catch (IOException e) {
            System.out.println("File read error: " + e.getMessage());
        }
    }
}
