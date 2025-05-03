import java.io.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.Base64;
public class EncryptDecryptCSV {
    private static final String SECRET_KEY = "1234567890123456"; 
    private static final String ALGORITHM = "AES";
    public static String encrypt(String data) throws Exception {
        SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedData = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedData); 
    }
    public static String decrypt(String encryptedData) throws Exception {
        SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedData = Base64.getDecoder().decode(encryptedData);
        byte[] originalData = cipher.doFinal(decodedData);
        return new String(originalData);
    }
    public static void main(String[] args) throws Exception {
        String inputFile = "EmployeeDetails.csv"; 
        String outputFile = "EncryptedEmployeeDetails.csv";
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            String line;
            boolean isHeader = true;
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                if (isHeader) {
                    writer.write(String.join(",", columns)); 
                    writer.newLine();
                    isHeader = false;
                } else {
                    String employeeId = columns[0].trim();
                    String name = columns[1].trim();
                    String email = encrypt(columns[2].trim()); 
                    String salary = encrypt(columns[3].trim());  
                    writer.write(employeeId + "," + name + "," + email + "," + salary);
                    writer.newLine();
                }
            }
            System.out.println("CSV file with encrypted sensitive data has been created: " + outputFile);
        } catch (IOException  e) {
           
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(outputFile))) {
            String line;
            boolean isHeader = true;
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                
                if (isHeader) {
                    System.out.println("Header: " + String.join(", ", columns)); 
                    isHeader = false;
                } else {
                    String employeeId = columns[0].trim();
                    String name = columns[1].trim();
                    String email = decrypt(columns[2].trim()); 
                    String salary = decrypt(columns[3].trim()); 
                    System.out.println("Employee ID: " + employeeId + ", Name: " + name + ", Email: " + email + ", Salary: " + salary);
                }
            }

        } catch (IOException  e) {
           
        }catch(Exception e){

        }
    }
}
