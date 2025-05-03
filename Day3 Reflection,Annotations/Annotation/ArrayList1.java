import java.util.ArrayList;
public class ArrayList1{
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList list = new ArrayList();  
        list.add("Apple");
        list.add("Banana");
        list.add("Grape");
        ArrayList<String> fruits = (ArrayList<String>) list;
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}
