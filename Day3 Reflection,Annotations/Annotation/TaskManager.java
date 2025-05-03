import java.lang.annotation.*;
import java.lang.reflect.Method;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo {
    String priority();
    String assignedTo();
}
public class TaskManager {
    @TaskInfo(priority = "High", assignedTo = "Alice")
    public void completeDocumentation() {
        System.out.println("Completing project documentation.");
    }
    @TaskInfo(priority = "Low", assignedTo = "Bob")
    public void cleanWorkspace() {
        System.out.println("Cleaning the workspace.");
    }
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        Method[] methods = manager.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(TaskInfo.class)) {
                TaskInfo info = method.getAnnotation(TaskInfo.class);
                System.out.println("Method: " + method.getName());
                System.out.println("  Priority: " + info.priority());
                System.out.println("  Assigned To: " + info.assignedTo());
                System.out.println();
            }
        }
    }
}
