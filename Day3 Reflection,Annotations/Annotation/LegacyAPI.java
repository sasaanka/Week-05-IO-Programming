class LegacyAPIm {
    @Deprecated
    public void oldFeature() {
        System.out.println("This is the old feature. Avoid using it.");
    }
    public void newFeature() {
        System.out.println("This is the new recommended feature.");
    }
}
@SuppressWarnings("deprecation")
public class LegacyAPI{
    public static void main(String[] args) {
        LegacyAPIm api = new LegacyAPIm(); 
        api.oldFeature();  
        api.newFeature();  
    }
}
