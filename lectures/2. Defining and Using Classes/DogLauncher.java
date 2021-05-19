public class DogLauncher {
    public static void main(String[] args) {
        Dog d1 = new Dog(20);
        d1.makeNoise();
        Dog d2 = new Dog(10);
        
        Dog dmax = Dog.maxDog(d1,d2);
        dmax.makeNoise();
    }
}
