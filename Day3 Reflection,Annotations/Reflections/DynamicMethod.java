import java.lang.reflect.Method;
import java.util.Scanner;
class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }
    public int subtract(int a, int b) {
        return a - b;
    }
    public int multiply(int a, int b) {
        return a * b;
    }
}

public class DynamicMethod {
    @SuppressWarnings("UseSpecificCatch")
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter operation (add, subtract, multiply): ");
            String operation = scanner.nextLine().trim();
            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt();
            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt();
            MathOperations mathOps = new MathOperations();
            Class<?> clazz = mathOps.getClass();
            Method method = clazz.getMethod(operation, int.class, int.class);
            Object result = method.invoke(mathOps, num1, num2);
            System.out.println("Result: " + result);

        } catch (Exception e) {

        }
    }
}
