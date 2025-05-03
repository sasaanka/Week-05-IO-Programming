import java.lang.annotation.*;
import java.lang.reflect.Field;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}
public class FieldValidation{
    @MaxLength(10)
    private String username;
    public FieldValidation(String username) {
        try {
            Field field = this.getClass().getDeclaredField("username");
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength maxLength = field.getAnnotation(MaxLength.class);
                if (username.length() > maxLength.value()) {
                    throw new IllegalArgumentException(
                        "Username exceeds max length of " + maxLength.value() + " characters."
                    );
                }
            }
            this.username = username;
        } catch (NoSuchFieldException e) {
            throw new RuntimeException("Field not found", e);
        }
    }
    public void printUser() {
        System.out.println("Username: " + username);
    }
    public static void main(String[] args) {
        try {
            FieldValidation u1 = new FieldValidation("Alice");
            u1.printUser();

            FieldValidation u2 = new FieldValidation("VeryLongUsername"); 
            u2.printUser();
        } catch (IllegalArgumentException e) {
            
        }
    }
}
