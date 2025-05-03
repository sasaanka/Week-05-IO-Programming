import java.lang.annotation.*;
import java.lang.reflect.Method;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value(); 
}
public class RoleBased {
    @RoleAllowed("ADMIN")
    public void performAdminTask() {
        System.out.println("Admin task performed.");
    }
    @RoleAllowed("USER")
    public void performUserTask() {
        System.out.println("User task performed.");
    }
    public void generalTask() {
        System.out.println("General task performed.");
    }
        public static void main(String[] args) throws Exception {
        RoleBased service = new RoleBased();
        String currentUserRole = "USER";  
        Method[] methods = RoleBased.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
                if (roleAllowed.value().equals(currentUserRole)) {
                    method.invoke(service);
                } else {
                    System.out.println("Access Denied to method: " + method.getName());
                }
            } else {
                method.invoke(service);
            }
        }
    }
}
