import java.lang.annotation.*;
import java.lang.reflect.*;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {}
class DatabaseService {
    public void connect() {
        System.out.println("Connected to the database.");
    }
}
class Application {
    @Inject
    private DatabaseService dbService;

    public void run() {
        dbService.connect();
        System.out.println("Application is running...");
    }
}
class SimpleDIContainer {
    public static void injectDependencies(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                Class<?> fieldType = field.getType();
                Object dependency = fieldType.getDeclaredConstructor().newInstance();
                field.setAccessible(true); 
                field.set(obj, dependency);
            }
        }
    }
}
public class DIUsingReflection {
    public static void main(String[] args) throws Exception {
        Application app = new Application();
        SimpleDIContainer.injectDependencies(app);
        app.run();
    }
}
