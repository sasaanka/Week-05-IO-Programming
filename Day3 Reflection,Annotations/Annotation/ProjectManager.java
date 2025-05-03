import java.lang.annotation.*;
import java.lang.reflect.Method;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}
public class ProjectManager {
    @ImportantMethod
    public void finalizeReport() {
        System.out.println("Finalizing the project report...");
    }
    @ImportantMethod(level = "MEDIUM")
    public void reviewCode() {
        System.out.println("Reviewing team code submissions...");
    }
    public void sendEmail() {
        System.out.println("Sending routine email...");
    }
    public static void main(String[] args) {
        ProjectManager pm = new ProjectManager();
        Method[] methods = pm.getClass().getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Important Method: " + method.getName());
                System.out.println("  Level: " + annotation.level());
                System.out.println();
            }
        }
    }
}
