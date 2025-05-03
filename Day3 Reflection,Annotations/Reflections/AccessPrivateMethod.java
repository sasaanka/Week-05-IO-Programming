import java.lang.reflect.Method;
class Calculator {
    @SuppressWarnings("unused")
    private int multiply(int a, int b) {
        return a * b;
    }
}

public class AccessPrivateMethod {
    @SuppressWarnings("UseSpecificCatch")
    public static void main(String[] args) {
        try {
            Calculator calculator = new Calculator();
            Class<?> clazz = calculator.getClass();
            Method multiplyMethod = clazz.getDeclaredMethod("multiply", int.class, int.class);
            multiplyMethod.setAccessible(true);
            Object result = multiplyMethod.invoke(calculator, 5, 10);
            System.out.println("Multiplication result: " + result);
        } catch (Exception e) {

        }
    }
}
