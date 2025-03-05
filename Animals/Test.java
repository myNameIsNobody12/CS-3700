public class Test
{
    public static void main(String[] args)
    {
        Animal a1 = new Animal("A1", 1);
        a1.makesNoise();
        Dog d1 = new Dog("D1", 1, "Husky");
        d1.makesNoise();    
    }
}