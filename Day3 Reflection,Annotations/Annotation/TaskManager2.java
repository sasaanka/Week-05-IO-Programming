import java.lang.annotation.*;
import java.lang.reflect.Method;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();  
}
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)  
@interface BugReport {
    String description();
}
public class TaskManager2 {
    @BugReport(description = "Null pointer exception in task creation.")
    @BugReport(description = "UI freezes when clicking submit.")
    public void processTask() {
        System.out.println("Processing task...");
    }
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        Method[] methods = manager.getClass().getDeclaredMethods();  
        for (Method method : methods) {
            if (method.isAnnotationPresent(BugReports.class)) {
                BugReports bugReports = method.getAnnotation(BugReports.class);  
                for (BugReport bugReport : bugReports.value()) {
                    System.out.println("Bug Report: " + bugReport.description());
                }
                System.out.println();
            }
        }
    }
}
