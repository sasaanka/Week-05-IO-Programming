package pack;
import org.json.JSONArray;
import org.json.JSONObject;
public class FilterJSONdata {
    public static void main(String[] args) {
        String jsonString = "[" +
                "{\"name\": \"Abhinaya\", \"age\": 30}," +
                "{\"name\": \"Bharath\", \"age\": 24}," +
                "{\"name\": \"Sasanka\", \"age\": 28}" +
                "]";
        JSONArray jsonArray = new JSONArray(jsonString);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject user = jsonArray.getJSONObject(i);
            int age = user.getInt("age");
            if (age > 25) {
                System.out.println(user.toString(2));
            }
        }
    }
}
