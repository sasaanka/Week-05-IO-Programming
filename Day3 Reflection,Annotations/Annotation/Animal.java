class Animal1 {
    public void makeSound() {
        System.out.println("Some generic animal sound");
    }
}
class Dog extends Animal1 {
    @Override
    public void makeSound() {
        System.out.println("Bowww boww!");
    }
}
public class Animal {
    public static void main(String[] args) {
        Dog myDog = new Dog();  
        myDog.makeSound();      
    }
}
