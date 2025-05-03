import java.lang.reflect.Method;
class Worker {
    public void fastTask() {
        System.out.println("Fast task running...");
    }
    @SuppressWarnings("CallToPrintStackTrace")
    public void slowTask() {
        try {
            Thread.sleep(500); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Slow task running...");
    }
}
public class MethodExecutionTiming {
    public static void main(String[] args) throws Exception {
        Worker worker = new Worker();
        Class<?> clazz = worker.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getParameterCount() == 0) { 
                System.out.println("Executing: " + method.getName());
                long start = System.nanoTime();
                method.invoke(worker); 
                long end = System.nanoTime();
                System.out.println("Execution Time: " + (end - start) / 1_000_000.0 + " ms\n");
            }
        }
    }
}
