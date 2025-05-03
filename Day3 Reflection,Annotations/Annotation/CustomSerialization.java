import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.*;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}
class User {
    @JsonField(name = "user_name")
    @SuppressWarnings("unused")
    final private String username;
    @JsonField(name = "email_address")
    @SuppressWarnings("unused")
    final private String email;
    @SuppressWarnings("unused")
    final private int age; 
    public User(String username, String email, int age) {
        this.username = username;
        this.email = email;
        this.age = age;
    }
}

class JsonSerializer {
    public static String toJson(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        StringBuilder json = new StringBuilder();
        json.append("{");
        Field[] fields = clazz.getDeclaredFields();
        List<String> jsonFields = new ArrayList<>();
        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true);
                JsonField annotation = field.getAnnotation(JsonField.class);
                String key = annotation.name();
                Object value = field.get(obj);
                jsonFields.add("\"" + key + "\": \"" + value + "\"");
            }
        }
        json.append(String.join(", ", jsonFields));
        json.append("}");
        return json.toString();
    }
}
public class CustomSerialization {
    public static void main(String[] args) throws IllegalAccessException {
        User user = new User("sasanka123", "sasanka@example.com", 30);
        String json = JsonSerializer.toJson(user);
        System.out.println(json);
    }
}
