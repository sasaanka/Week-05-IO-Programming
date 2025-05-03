import java.lang.annotation.*;
import java.lang.reflect.Method;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}
public class PendingTask{
    @Todo(task = "Implement user login", assignedTo = "Alice", priority = "HIGH")
    public void loginFeature() {
        System.out.println("Pending: User login");
    }
    @Todo(task = "Add search functionality", assignedTo = "Bob")
    public void searchFeature() {
        System.out.println("Pending: Search functionality");
    }
    public void completedFeature() {
        System.out.println("Completed: Dashboard");
    }
    public static void main(String[] args) {
        Method[] methods = PendingTask.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("Method: " + method.getName());
                System.out.println("  Task: " + todo.task());
                System.out.println("  Assigned To: " + todo.assignedTo());
                System.out.println("  Priority: " + todo.priority());
            }
        }
    }
}
