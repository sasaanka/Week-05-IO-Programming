import java.lang.reflect.Field;
import java.util.Map;
class Person {
    private String name;
    private int age;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + '}';
    }
}

public class CustomObjectMapper {
    @SuppressWarnings({"CallToPrintStackTrace", "UseSpecificCatch"})
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            T obj = clazz.getDeclaredConstructor().newInstance();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (properties.containsKey(field.getName())) {
                    Object value = properties.get(field.getName());
                    field.set(obj, value);
                }
            }
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        Map<String, Object> properties = Map.of(
                "name", "Sasanka",
                "age", 20
        );
        Person person = toObject(Person.class, properties);
        if (person != null) {
            System.out.println(person);
        } else {
            System.out.println("Error creating the object.");
        }
    }
}
