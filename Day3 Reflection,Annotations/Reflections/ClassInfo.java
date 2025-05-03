import java.lang.reflect.*;
import java.util.Scanner;
public class ClassInfo {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) { 
            System.out.print("Enter full class name (e.g., java.util.ArrayList): ");
            String className = scanner.nextLine();
            try {
                Class<?> clazz = Class.forName(className);
                System.out.println("\nClass: " + clazz.getName());
                System.out.println("\nConstructors:");
                Constructor<?>[] constructors = clazz.getDeclaredConstructors();
                for (Constructor<?> cons : constructors) {
                    System.out.println("  " + cons);
                }
                System.out.println("\nFields:");
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    System.out.println("  " + field);
                }
                System.out.println("\nMethods:");
                Method[] methods = clazz.getDeclaredMethods();
                for (Method method : methods) {
                    System.out.println("  " + method);
                }
            } catch (ClassNotFoundException e) {
                System.out.println("Class not found: " + className);
            }
        }
}
}
