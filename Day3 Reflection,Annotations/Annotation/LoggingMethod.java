import java.lang.annotation.*;
import java.lang.reflect.Method;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {
}
public class LoggingMethod {
    @LogExecutionTime
    public void fastMethod() {
        for (int i = 0; i < 1000; i++) {
            Math.sqrt(i);
        }
    }
    @LogExecutionTime
    public void slowMethod() {
        for (int i = 0; i < 1000000; i++) {
            Math.sqrt(i);
        }
    }
    public void normalMethod() {
        System.out.println("This method is not timed.");
    }
    public static void main(String[] args) throws Exception {
        LoggingMethod obj = new LoggingMethod();
        Method[] methods = LoggingMethod.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long start = System.nanoTime();
                method.invoke(obj);
                long end = System.nanoTime();
                long duration = end - start;
                System.out.println("Execution Time of " + method.getName() + ": " + duration / 1_000_000.0 + " ms");
                System.out.println();
            }
        }
    }
}
