import java.lang.annotation.*;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)  
@interface Author {
    String name();  
}
@Author(name = "Sasanka")  
class MyClass {
    
}
public class RetriveAnotations {
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        try {
            Class<?> clazz = MyClass.class;
            if (clazz.isAnnotationPresent(Author.class)) {
                Author author = clazz.getAnnotation(Author.class);
                System.out.println("Author Name: " + author.name());
            } else {
                System.out.println("No Author annotation present.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
