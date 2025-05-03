import java.lang.annotation.*;
import java.util.HashMap;
import java.util.Map;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {}
class Calculator {
    final private Map<Integer, Integer> squareCache = new HashMap<>();
    @CacheResult
    public int computeSquare(int num) {
        if (squareCache.containsKey(num)) {
            System.out.println("Returning cached result for " + num);
            return squareCache.get(num);
        }
        System.out.println("Computing square for " + num);
        int result = num * num; 
        squareCache.put(num, result);
        return result;
    }
}
public class CachingSystem {
    public static void main(String[] args) throws Exception {
        Calculator calc = new Calculator();
        System.out.println("Result: " + calc.computeSquare(5));  
        System.out.println("Result: " + calc.computeSquare(5));  
        System.out.println("Result: " + calc.computeSquare(10)); 
        System.out.println("Result: " + calc.computeSquare(10));
    }
}
