import java.lang.reflect.Field;
class Configuration {
    final private static String API_KEY = "InitialAPIKey";
    public static void displayAPIKey() {
        System.out.println("API Key: " + API_KEY);
    }
}
public class AccessStaticField {
    @SuppressWarnings({"UseSpecificCatch", "CallToPrintStackTrace"})
    public static void main(String[] args) {
        try {
            Class<?> clazz = Configuration.class;
            Field apiKeyField = clazz.getDeclaredField("API_KEY");
            apiKeyField.setAccessible(true);
            apiKeyField.set(null, "UpdatedAPIKey");
            Configuration.displayAPIKey();  
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
