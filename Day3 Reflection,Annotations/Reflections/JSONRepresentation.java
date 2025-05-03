import java.lang.reflect.Field;
class Person {
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
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
}
public class JSONRepresentation {
    @SuppressWarnings("CallToPrintStackTrace")
    public static String toJson(Object obj) {
        StringBuilder json = new StringBuilder();
        json.append("{");
        Field[] fields = obj.getClass().getDeclaredFields();
        try {
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                field.setAccessible(true); 
                String fieldName = field.getName();
                Object fieldValue = field.get(obj);
                json.append("\"").append(fieldName).append("\": \"").append(fieldValue).append("\"");
                if (i < fields.length - 1) {
                    json.append(", ");
                }
            }

            json.append("}");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return json.toString();
    }
    public static void main(String[] args) {
        Person person = new Person("Sasanka",20);
        String jsonString = toJson(person);
        System.out.println(jsonString);
    }
}
