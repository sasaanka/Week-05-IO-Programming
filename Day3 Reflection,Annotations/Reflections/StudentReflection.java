import java.lang.reflect.Constructor;
class Student {
    final private String name;
    final private int age;
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void displayInfo() {
        System.out.println("Student Name: " + name);
        System.out.println("Student Age: " + age);
    }
}
public class StudentReflection {
    @SuppressWarnings("UseSpecificCatch")
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("Student");
            Constructor<?> constructor = clazz.getConstructor(String.class, int.class);
            Object studentObj = constructor.newInstance("Sasanka", 20);
            Student student = (Student) studentObj;
            student.displayInfo();

        } catch (Exception e) {
 
        }
    }
}
