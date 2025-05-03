import java.lang.reflect.Field;
class Person {
    final private int age = 25;  
    public void displayAge() {
        System.out.println("Age: " + age);
    }
}
public class AccessPrivateField {
    @SuppressWarnings("UseSpecificCatch")
    public static void main(String[] args) {
        try {
            Person person = new Person();
            Class<?> clazz = person.getClass();
            Field ageField = clazz.getDeclaredField("age");
            ageField.setAccessible(true);
            ageField.setInt(person, 40);
            int modifiedAge = ageField.getInt(person);
            System.out.println("Modified Age using Reflection: " + modifiedAge);
            person.displayAge();

        } catch (Exception e) {
            
        }
    }
}
